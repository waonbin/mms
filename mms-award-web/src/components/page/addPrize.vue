<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-tickets"></i> 新建奖项
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="operate">
                <el-button type="info" @click="$router.push('/prize')">
                    取消
                </el-button>
                <el-button type="primary" @click="check">
                    发布
                </el-button>
            </div>

            <div class="base">
                <el-form class="base-from" ref="form" label-width="80px">
                    <el-form-item label="奖项名称">
                        <el-input v-model.trim="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="奖项内容">
                        <el-input type="textarea"
                                  v-model.trim="form.content"></el-input>
                    </el-form-item>
                </el-form>
            </div>

            <div>
                <el-tabs v-model="activeName" @tab-click="handleClick">
                    <el-tab-pane label="奖项设置" name="first">
                        <el-form class="base-from" ref="awardForm" label-width="80px">
                            <el-form-item label="申报时间">
                                <el-date-picker
                                        v-model="form.declareDate"
                                        type="date"
                                        placeholder="选择日期">
                                </el-date-picker>
                            </el-form-item>
                            <el-form-item label="初审时间">
                                <el-date-picker
                                        v-model="form.firstTrialDate"
                                        type="date"
                                        placeholder="选择日期">
                                </el-date-picker>
                            </el-form-item>
                            <el-form-item label="复查时间">
                                <el-date-picker
                                        v-model="form.retrialDate"
                                        type="date"
                                        placeholder="选择日期">
                                </el-date-picker>
                            </el-form-item>
                            <el-form-item label="奖项类别">
                                <el-input v-model.trim="form.category"></el-input>
                                <p class="tip">注：奖项类别以逗号分隔</p>
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="推荐设置" name="second">
                        <div class="clearfix">
                            <el-button type="primary" class="unifying-quota-btn"
                                       @click="dialogVisible = true">
                                统一设置名额
                            </el-button>
                        </div>
                        <el-table
                                :data="tableData"
                                max-height="600"
                                class="tjTable"
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
                                    label="推荐单位名称"
                                    show-overflow-tooltip
                                    width="280">
                            </el-table-column>
                            <el-table-column
                                    prop="name"
                                    header-align="center"
                                    label="单位地点"
                                    show-overflow-tooltip
                                    width="250">
                            </el-table-column>
                            <el-table-column
                                    prop="desc"
                                    header-align="center"
                                    label="单位领导">
                            </el-table-column>
                            <el-table-column
                                    prop="desc"
                                    header-align="center"
                                    label="奖项负责人"
                                    width="90"
                            >
                            </el-table-column>
                            <el-table-column
                                    prop="desc"
                                    header-align="center"
                                    label="联系方式">
                            </el-table-column>
                            <el-table-column
                                    fixed="right"
                                    header-align="center"
                                    align="center"
                                    label="名额设置"
                                    width="200">
                                <template slot-scope="scope">
                                    推荐名额
                                    <el-input type="Number"></el-input>
                                </template>
                            </el-table-column>
                        </el-table>
                    </el-tab-pane>
                </el-tabs>
            </div>
        </div>
        <el-dialog
                title="操作"
                :visible.sync="dialogVisible"
                class="tyszme"
                width="30%"
        >
            <div>
                统一设置名额
                <el-input type="Number"></el-input>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
             </span>
        </el-dialog>
    </div>
</template>

<script>
    import baseUrl from 'src/apis/api'

    export default ({
        data() {
            return {
                activeName: 'first',
                form: {
                    name: '',
                    content: '',
                    declareDate: '',
                    firstTrialDate: '',
                    retrialDate: '',
                    category: ''
                },
                tableData: [{
                    date: '2016-05-032016-05-03',
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
                multipleSelection: [],
                dialogVisible: false
            }
        },
        methods: {
            check() {
                if (!this.form.name.length) {
                    this.$message.warning("请填写奖项名称！");
                    return false
                } else if (!this.form.content.length) {
                    this.$message.warning("请填写奖项内容！");
                    return false
                } else {
                    this.submit()
                }
            },
            changeTime(time) {
                if (!time) {
                    return ""
                }

                var y = time.getFullYear(),
                    m = time.getMonth() + 1,
                    d = time.getDate();

                if (m < 10) {
                    m = '0' + m
                }
                if (d < 10) {
                    d = '0' + d
                }
                return y + '-' + m + '-' + d

            },
            clear() {
                this.form = {
                    name: '',
                    content: '',
                    declareDate: '',
                    firstTrialDate: '',
                    retrialDate: '',
                    category: ''
                }
            },
            submit() {
                let url = '/award/awards/save';
                let params = {
                    name: this.form.name,
                    content: this.form.content
                };

                if (this.activeName === 'first') {
                    params.declareDate = this.changeTime(this.form.declareDate);
                    params.firstTrialDate = this.changeTime(this.form.firstTrialDate);
                    params.retrialDate = this.changeTime(this.form.retrialDate);
                    params.category = this.form.category;
                }

                $.ajax({
                    url: baseUrl + url,
                    type: 'post',
                    data: params
                }).done(function (data) {
                    this.$message.success("保存成功！");
                    this.clear()
                }.bind(this)).fail(function () {
                    this.$message.warning("保存失败！")
                }.bind(this))
            },
            handleClick(val) {

            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        }
    })
</script>

<style scoped>
    .base-from {
        width: 500px;
        margin: 20px 0;
    }

    .tip {
        color: #999
    }

    .tjTable .el-input {
        width: 100px;
        margin-left: 10px;
    }

    .unifying-quota-btn {
        float: right;
        margin-bottom: 10px;
    }

    .tyszme .el-input {
        width: 150px;
        margin-left: 17px;
    }
</style>