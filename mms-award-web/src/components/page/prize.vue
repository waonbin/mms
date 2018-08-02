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
                        :data="tableData3"
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
                            prop="date"
                            header-align="center"
                            label="奖项名称"
                            show-overflow-tooltip
                            width="280">
                    </el-table-column>
                    <el-table-column
                            prop="name"
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
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <div class="pagination">
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="1000">
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
                page: '1',
                tableData3: [{
                    date: '2016-05-03',
                    name: '挎包',
                    desc: '产品描述'
                }, {
                    date: '2016-05-02',
                    name: '挎包',
                    desc: '产品描述'
                }, {
                    date: '2016-05-04',
                    name: '挎包',
                    desc: '产品描述'
                }, {
                    date: '2016-05-01',
                    name: '挎包',
                    desc: '产品描述'
                }, {
                    date: '2016-05-08',
                    name: '挎包',
                    desc: '产品描述'
                }, {
                    date: '2016-05-06',
                    name: '挎包',
                    desc: '产品描述'
                }, {
                    date: '2016-05-07',
                    name: '挎包',
                    desc: '产品描述'
                }],
                multipleSelection: []
            }
        },
        methods: {
            getData() {
                const url ='/award/awards/page/'+this.page;

                $.ajax({
                    crossDomain: true,//标记要跨域请求
                    jsonp: "action",//请求处理标注，和jsonpCallback 相对应。
                    jsonpCallback: "asyncAjax",
                }).done(function(data) {
                    console.log(data)
                }.bind(this))
            },
            addProduct() {
                this.$router.push({path: '/add-prize'})
            },
            handleClick(row) {
                console.log(row);
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
