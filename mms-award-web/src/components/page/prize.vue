<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-tickets"></i> 奖项列表
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="operate">
                <el-button type="primary" icon="el-icon-plus"
                           @click="addProduct">
                    新建奖项
                </el-button>
                <el-button type="danger" icon="el-icon-delete"
                           @click="del">
                    删除
                </el-button>
            </div>
            <div class="search-box clearfix">
                <div class="search-item">
                    奖项名称：
                    <el-input></el-input>
                </div>
                <el-button type="primary" icon="el-icon-search">搜索</el-button>
            </div>
            <div class="table-box">
                <el-table
                        :data="tableData"
                        max-height="600"
                        border
                        @selection-change="handleSelectionChange"
                        style="width: 100%">
                    <el-table-column
                            type="selection"
                            header-align="center"
                            align="center"
                            width="55">
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            header-align="center"
                            label="奖项名称"
                            show-overflow-tooltip
                            width="280">
                    </el-table-column>
                    <el-table-column
                            prop="declareDate"
                            header-align="center"
                            label="起止时间"
                            width="300">
                    </el-table-column>
                    <el-table-column
                            prop="desc"
                            header-align="center"
                            label="投递数量">
                    </el-table-column>
                    <el-table-column
                            prop="desc"
                            header-align="center"
                            label="评奖进度">
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            header-align="center"
                            align="center"
                            label="操作"
                            width="100">
                        <template slot-scope="scope">
                            <el-button type="text" size="small">编辑</el-button>
                            <el-button type="text" size="small"
                                @click="delet(scope.row.id)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <div class="pagination">
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="totalElements"
                        @current-change="handleCurrentChange"
                >
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    import  baseUrl from 'src/apis/api'

    export default {
        data() {
            return {
                page: '0',
                totalElements: 0,
                tableData: [],
                multipleSelection: []
            }
        },
        methods: {
            getData() {
                const url ='/award/awards/page/'+this.page;

                $.ajax({
                    url: baseUrl+url,
                }).done(function(data) {
                    this.tableData = data.content;
                    this.totalElements = data.totalElements;
                }.bind(this)).fail(function() {
                    this.$message.warning("获取数据失败！")
                }.bind(this))
            },
            addProduct() {
                this.$router.push({path: '/add-prize'})
            },
            delet(id) {
                let url = '/award/awards/delete';

                this.$confirm('确定删除此条数据？', '确认信息', {
                    distinguishCancelAndClose: true,
                    confirmButtonText: '保存',
                    cancelButtonText: '取消'
                }).then(() => {
                    $.ajax({
                        url: baseUrl+url,
                        type: 'post',
                        data: {
                            id: id
                        }
                    }).done(function(data) {
                        this.$message.success("删除成功！");
                        this.getData();
                    }.bind(this)).fail(function() {
                        this.$message.warning("获取数据失败！")
                    }.bind(this))
                }).catch(() => {

                });
            },
            handleClick(row) {
                console.log(row);
            },
            handleCurrentChange(val) {
                if(this.page != val){
                    this.page = val;
                    this.getData();
                }
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            del() {
                this.$confirm('是否确定删除此产品？', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                }).catch(() => {

                });
            }
        },
        mounted() {
            this.getData()
        }
    }

</script>

<style scoped>
    .search-box {
        margin: 20px 0;
    }

    .search-item {
        float: left;
        margin-right: 30px;
    }

    .search-item .el-input {
        width: 180px;
    }

    .table-box {
        margin-top: 10px;
    }
</style>
