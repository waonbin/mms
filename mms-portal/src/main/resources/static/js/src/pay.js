$(function () {
    new Vue({
        el: "#pay-content",
        data: {
            page: 1,
            message: {
                id: '',
                name: ''
            },
            ws: null, //WebSocket
            payType: '1',
            onlineType: '2', //1-支付宝 2-微信
            isKaipiao: '1',
            uploadUrl: ctxPath + '/file/upload',
            step: 1,
            dues: '', //会费金额-每年
            duration: '', //会费金额-年
            uploadFileId: 0, //上传文件返回的id;
            qrCodeDialog: false,
            loading: true,
            typeList: [],
            cityList: [],
            dictionaryList: [],
            order: {
                recipients: '',
                recipientsMobile: '',
                deliveryType: '1',
                invoiceType: '1',
                titleType: '1',
                invoiceId: '',
                tin:'',
                province: '',
                city: '',
                recipientsAddress: '',
                recipientsZipcode: ''
            },
            list: {}
        },
        computed: {
            provinceList: function () {
                return this.cityList.filter(function (item) {
                    return item.parentId === 0
                })
            },
            invoiceList: function () {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 13
                })
            },
            citiesList: function () {
                return this.cityList.filter(function (item) {
                    return item.parentId === this.order.province
                }.bind(this))
            }
        },
        methods: {
            checkOrder: function () {
                var order = this.order;

                //不开票不需要验证
                if(this.isKaipiao == 1) {
                    return true
                };

                //抬头类型为单位时要输入抬头
                if(order.titleType == 2) {

                    if(!order.invoiceId.length) {
                        this.$message.error('抬头类型为单位时，请输入抬头！');
                        return false;
                    }
                    if(!order.tin.length) {
                        this.$message.error('请输入纳税人识别号！');
                        return false;
                    }
                }


                if(order.deliveryType != 1) {

                    if(!order.recipients.length) {
                        this.$message.error('请输入收件人姓名！');
                        return false;
                    }
                    if(!order.recipientsMobile.length) {
                        this.$message.error('请输入手机号码！');
                        return false;
                    }
                    if(!order.recipientsMobile.length) {
                        this.$message.error('请输入手机号码！');
                        return false;
                    }
                    if(!order.province) {
                        this.$message.error('请输入省');
                        return false;
                    }
                    if(!order.city) {
                        this.$message.error('请输入市！');
                        return false;
                    }
                    if(!order.recipientsAddress.length) {
                        this.$message.error('请输入详细地址');
                        return false;
                    }
                    if(!order.recipientsZipcode.length) {
                        this.$message.error('请输入邮政编码！');
                        return false;
                    }
                }

                return true;
            },
            onStep: function (page) {
                if (page === 2 && this.checkOrder()) {
                    this.submitPost();
                    this.step = Number(page)
                }
            },
            submitPost: function () {
                var parms = this.order;

                if (this.order.titleType == 1) {
                    parms.taitleType = null;
                    parms.tin = null
                }
                if (this.dues && this.duration) {
                    parms.amount = Number(this.dues) * Number(this.duration)
                }
                if (this.order.deliveryType == 1) {
                    parms.recipients = null;
                    parms.recipientsMobile = null;
                    parms.province = null;
                    parms.city = null;
                    parms.recipientsAddress = null;
                    parms.recipientsZipcode = null;
                }

                var keys = Object.keys(parms),data={};

                keys.forEach(function(item) {
                   if(parms[item]) {
                       data[item] = parms[item]
                   }
                });

                $.ajax({
                    url: ctxPath + '/order/order',
                    type: 'post',
                    data: data
                })
            },
            //设置webStoker
            infoWS: function() {
                var ws = new WebSocket("wss://echo.websocket.org");

                ws.onopen = function(evt) {
                    console.log("Connection open ...");
                    ws.send("Hello WebSockets!");
                };

                ws.onmessage = function(evt) {
                    console.log( "Received Message: " + evt.data);
                    ws.close();
                };

                ws.onclose = function(evt) {
                    console.log("Connection closed.");
                };
            },
            //获取完微信地址转化为二维码
            changeImgUrl: function (url) {
                $('#qrcode').qrcode({
                    render: "canvas", //也可以替换为table
                    width: 150,
                    height: 150,
                    text: url
                });

            },
            getWXCode: function() {
              $.ajax({
                  url: ctxPath + '/wxpay/membership/pay',
                  type: 'post',
                  data: {
                      body: '会费',
                      orderNo: '2016090910595900000012',
                      totalFee: '0.01'
                  }
              }).done(function(data) {
                  if(data.resultCode.toLocaleLowerCase() === 'success'
                    && data.returnCode.toLocaleLowerCase() === 'success') {
                      this.changeImgUrl(data.codeUrl)
                  }
              }.bind(this)).fail(function() {
                  this.$message.error('获取失败');
              }.bind(this)).always(function() {
                  this.loading  = false;
              }.bind(this))
            },
            goPay: function() {
                this.loading = true;
                this.qrCodeDialog = true;

                if(this.onlineType == 2) {
                    this.getWXCode()
                }
            },
            getDictionary: function() {
                $.ajax({
                    url:ctxPath+'/dictionary'
                }).done(function(data) {
                    this.dictionaryList = data;
                }.bind(this))
            },
            handleRemove: function (file, fileList) {
                console.log(file);
                $.ajax({
                    url: ctxPath + '/file/delete',
                    type: 'post',
                    data: {
                        id: this.uploadFileId
                    }
                }).done(function () {
                    this.uploadFileId = '';
                    this.$message({
                        message: '删除成功',
                        type: 'success'
                    });
                }.bind(this))
            },
            handSuccess: function (data) {
                this.uploadFileId = data.id;
                this.$message({
                    message: '上传成功',
                    type: 'success'
                });
            },
            handError: function () {
                this.$message.error('上传失败');
            },
            handExceed: function (file) {
                this.$message.error('最多只能上传1个文件！');
            },
            getMessage: function () {
                $.ajax({
                    url: ctxPath + '/login/user'
                }).done(function (date) {
                    this.message = date;
                }.bind(this)).fail(function () {
                    this.$message.error('获取用户信息失败！');
                }.bind(this))
            },
            getDues: function () {
                $.ajax({
                    url: ctxPath + '/payment/dues'
                }).done(function (date) {
                    this.dues = date;
                }.bind(this))
            },
            getDuration: function () {
                $.ajax({
                    url: ctxPath + '/payment/duration'
                }).done(function (date) {
                    this.duration = date;
                }.bind(this))
            },
            getCity: function () {
                $.ajax({
                    url: ctxPath + '/division/data'
                }).done(function (data) {
                    this.cityList = data;
                }.bind(this))
            },
            changePage: function (val) {
                this.page = val;
                this.getDate()
            },
            beforeUpload(file) {

            },
            //线下提交
            underLineSubmit: function () {
                var params = {
                    id: this.message.id,
                    orderNo: '',
                    memberId: '',
                    orderType: '',
                    orderAmount: '100',
                    payStatus: '',
                    payType: this.payType,
                    onlineType: '',
                    offlineVoucher: this.uploadFileId,
                    payTime: ''
                };

                $.ajax({
                    url: ctxPath + '/payment/pay',
                    type: 'post',
                    data: params
                }).done(function () {
                    this.step = 3;
                }.bind(this)).fail(function () {
                    this.$message.error('提交失败');
                })
            }
        },
        mounted: function () {
            $(".payment-btn").addClass('cur');
            this.getMessage();
            this.getDues();
            this.getDictionary();
            this.getDuration();
            this.getCity();
        }
    })
});