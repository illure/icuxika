<template>
    <div>
        <div>
            <b-progress :value="progressValue" :max="progressMaxValue"
                        :variant="progressVariant" :key="progressKey"
                        show-progress animated></b-progress>
        </div>
        <div>
            <input type="file" @change="upload">
        </div>
        <div>
            <button type="button" @click="download">下载图片</button>
        </div>
        <div>
            <!-- Styled -->
            <b-form-file v-model="file1" :state="Boolean(file1)" placeholder="Choose a file..."></b-form-file>
            <div class="mt-3">Selected file: {{file1 && file1.name}}</div>

            <!-- Plain mode -->
            <b-form-file v-model="file2" class="mt-3" plain></b-form-file>
            <div class="mt-3">Selected file: {{file2 && file2.name}}</div>
        </div>
        <div class="mt-3">
            <!-- Multiple files -->
            <b-form-file v-model="files" multiple></b-form-file>
            <br> Selected file : {{[].map.call(files, f=>f.name).join(',')}}
        </div>
        <div>
            {{[].map.call(files, f=>f.name)}}
            <button type="button" @click="uploads">上传多个文件</button>
            <button type="button" @click="test">测试</button>
            {{filesDisplay}}
        </div>
    </div>
</template>

<script>
import '../../plugins/bootstrap'
export default {
  name: 'FileUpDown',
  data: function () {
    return {
      progressValue: 0,
      progressMaxValue: 100,
      progressVariant: 'secondary',
      progressKey: 'secondary',
      file1: null,
      file2: null,
      files: [],
      filesDisplay: ''
    }
  },
  methods: {
    upload (event) {
      let thisAttribute = this
      let file = event.target.files[0]
      console.log(event.target.files[0].name)
      let formData = new FormData()
      formData.append('file', file)
      console.log(formData.getAll('file'))
      const config = {
        headers: {
          'Content-Type': 'multipart/form-data'
        },
        // `onUploadProgress` 允许为上传处理进度事件
        onUploadProgress: function (progressEvent) {
          // 对原生进度事件的处理
          thisAttribute.progressValue = progressEvent.loaded / progressEvent.total * 100 | 0
        }
      }
      this.$axios.post('http://localhost:8888/test/upload', formData, config).then(response => {
        console.log(response.data)
        console.log(response.status)
      })
    },
    uploads () {
      let thisAttribute = this
      let files = thisAttribute.files
      let formData = new FormData()
      for (let i = 0; i < files.length; i++) {
        formData.append('files', files[i])
      }
      const config = {
        headers: {
          'Content-Type': 'multipart/form-data'
        },
        // `onUploadProgress` 允许为上传处理进度事件
        onUploadProgress: function (progressEvent) {
          // 对原生进度事件的处理
          thisAttribute.progressValue = progressEvent.loaded / progressEvent.total * 100 | 0
        }
      }
      this.$axios.post('http://localhost:8888/test/uploads', formData, config).then(response => {
        console.log(response.data)
        console.log(response.status)
      })
    },
    download () {
      let thisAttribute = this
      this.$axios({
        url: '/test/download',
        method: 'post',
        baseURL: 'http://localhost:8888',
        responseType: 'blob',
        // `onDownloadProgress` 允许为下载处理进度事件
        onDownloadProgress: function (progressEvent) {
          // 对原生进度事件的处理
          thisAttribute.progressValue = progressEvent.loaded / progressEvent.total * 100 | 0
        }
      }).then(function (response) {
        let blob = new Blob([response.data], { type: 'image/png' })
        let objectUrl = URL.createObjectURL(blob)
        // window.location.href = objectUrl
        window.open(objectUrl)
      })
    },
    test () {
      let thisAttribute = this
      let files = thisAttribute.files
      console.log(files)
      for (let i = 0; i < files.length; i++) {
        thisAttribute.filesDisplay += files[i].name
      }
    }
  }
}
</script>

<style scoped>

</style>
