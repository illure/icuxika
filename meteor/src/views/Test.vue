<template>
    <div>
        <div>
            <Table/>
        </div>
        <div>
            <Alert/>
        </div>
        <div>
            <FileUpDown/>
        </div>
        <div>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
            =============================================<br/>
        </div>
    </div>
</template>

<script>
import Table from '../components/bootstrap/Table'
import Alert from '../components/bootstrap/Alert'
import FileUpDown from '../components/bootstrap/FileUpDown'
export default {
  name: 'Test',
  components: { FileUpDown, Alert, Table }
}
</script>

<style scoped>

</style>
