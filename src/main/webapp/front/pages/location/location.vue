<template>
    <div class="location-container">
        <Tabs
            :TabList="TabList"
            :currentTab="current"
            @tabs="tabsChange"
        >
            <TabPane>
                <div class="add-localtion-wrap tab-wrap">
                    <div class="get-localtion-wrap">
                        <span>每天最多填1份</span>
                        <button @click="getLocaltionHandle">点击尝试自动获取位置</button>
                    </div>
                    <div class="localtion-form-wrap">
                        <div class="input-wrap">
                            <div>
                                <span>当天体温</span>
                                <i class="input-require-tab">*</i>
                            </div>
                            <input type="number" v-model="locationForm.temperature" placeholder="请输入提问">
                        </div>
                        <div class="input-wrap">
                            <div>
                                <span>表现症状</span>
                                <i class="input-require-tab">*</i>
                            </div>
                            <radio-group @change="symptomRadioChange">
                                <div class="radio-item">
                                    <radio value="0" />无异常
                                </div>
                                <div class="radio-item">
                                    <radio value="1" />发烧
                                </div>
                                <div class="radio-item">
                                    <radio value="2" />咳嗽
                                </div>
                                <div class="radio-item">
                                    <radio value="3" />乏力
                                </div>
                                <div class="radio-item">
                                    <radio value="4" />呼吸困难
                                </div>
                            </radio-group>
                        </div>
                        <div class="input-wrap">
                            <div>
                                <span>就医情况</span>
                                <i class="input-require-tab">*</i>
                            </div>
                            <radio-group @change="isHospitalizeRadioChange">
                                <div class="radio-item">
                                    <radio value="0" />未就医
                                </div>
                                <div class="radio-item">
                                    <radio value="1" />已就医
                                </div>
                            </radio-group>
                        </div>
                        <div class="input-wrap">
                            <div>
                                <span>隔离情况</span>
                                <i class="input-require-tab">*</i>
                            </div>
                            <radio-group @change="insulateStatusRadioChange">
                                <div class="radio-item">
                                    
                                    <radio value="0" />未隔离
                                </div>
                                <div class="radio-item">

                                    <radio value="1" />已被隔离
                                </div>
                            </radio-group>
                        </div>
                        <div class="input-wrap">
                            <div>
                                <span>最新接触</span>
                                <i class="input-require-tab">*</i>
                            </div>
                            <input type="text" v-model="locationForm.newContact" placeholder="今日最新去处接触了那些人员">
                        </div>
                        <div class="input-wrap">
                            <div>
                                <span>自动获取位置</span>
                                <i class="input-require-tab">*</i>
                                <pre>(点击重新获取位置)</pre>
                            </div>
                            <input type="text" v-model="locationForm.locationInfo" placeholder="系统自动获取位置信息">
                        </div>
                        <div class="input-wrap-tip">
                            <span>标记有</span>
                            <i class="input-require-tab">*</i>
                            <span>的是必填项</span>
                        </div>
                        <button class="input-submit" @click="saveHandle">提交</button>
                    </div>
                </div>
            </TabPane>
            <TabPane>
                <div class="incorrect-info-wrap tab-wrap">
                    <div class="incorrect-info-tip">
                        只有当天填写的数据可以修改
                    </div>
                    <div class="incorrect-time-wrap">
                        <div class="incorrect-time" v-for="item of localtionList" :key="item.id">{{item.createTime}} 填写</div>
                    </div>
                </div>
            </TabPane>
        </Tabs>
    </div>
</template>
<script>
import Tabs from '@/components/wiszx-tabs/tabs.vue'
import TabPane from '@/components/wiszx-tabs/tabPane.vue'

import QQMapWX from '@/common/qqmap/qqmap-wx-jssdk'

export default {
    components: {
        Tabs,
        TabPane
    },
    data() {
        return{
            current:0,
            TabList:[
                {title:'新增'},
                {title:'已填报记录'}
            ],
            qqmapsdk: null,
            localtionInfo: "每天最多填1份",
            locationForm: {
                yonghuId: null,
                temperature: '',
                symptom: '',
                isHospitalize: '',
                insulateStatus: '',
                newContact: '',
                locationInfo: ''
            },
            localtionList: []
        }
    },
    onLaunch() {

    },
    onLoad() {
        this.qqmapsdk = new QQMapWX({
            // 在腾讯平台自己申请的秘钥
            key: 'QQ4BZ-6IL36-WMESL-EPG25-2QB6J-TKBGS' 
        })
    },
    onShow() {
    },
    mounted() {
        let tempUserId = uni.getStorageSync('userid')
        if(!tempUserId) uni.navigateTo({ url: "/pages/login/login" })
        this.locationForm.yonghuId = tempUserId
    },
    methods: {
        tabsChange(index){
            this.current = index
            this.$http.request({
                url: 'location/listBy/'+this.locationForm.yonghuId,
                method: 'get',
            }).then(res => {
                this.localtionList = res.data
            })
            
        },
        // 点击获取自动获取位置
        getLocaltionHandle() {
            let vm = this
            uni.getLocation({
                type: 'gcj02', //返回可以用于uni.openLocation的经纬度
                success: function (res) {
                    const latitude = res.latitude;
                    const longitude = res.longitude;
                    uni.openLocation({
                        latitude: latitude,
                        longitude: longitude,
                        success: function () {
                            vm.qqmapsdk.reverseGeocoder({
                                location: {
                                    latitude: latitude,
                                    longitude: longitude
                                },
                                success: function (res) {
                                    if(res.status != 0) {
                                        return uni.showToast("获取位置失败")
                                    }
                                    vm.locationForm.locationInfo = res.result.address
                                },
                                    fail: function (res) {
                                    console.log(res)
                                },
                                complete: function (res) {
                                    // console.log(res)
                                }
                            })

                        }
                    });
                }
            });
        },
        // 表现症状
        symptomRadioChange(e) {
            this.locationForm.symptom = e.detail.value
        },
        // 就医情况
        isHospitalizeRadioChange(e) {
            this.locationForm.isHospitalize = e.detail.value
        },
        // 隔离情况
        insulateStatusRadioChange(e){
            this.locationForm.insulateStatus = e.detail.value
        },
        async saveHandle() {
            const res = await this.$http.request({
                url: 'location/save',
                method: 'post',
                data: this.locationForm
            })
        }
    }
}
</script>
<style lang="scss">
.location-container{
    .tab-wrap{  
    }
    .add-localtion-wrap{
        .get-localtion-wrap{
            display: flex;
            align-items: center;
            justify-content: flex-end;
            padding: 10rpx 20rpx;
            span{
                color: #9b9b9b;
                padding-right: 10rpx;
            }
            button{
                color: #fff;
                background: #009585;
                font-size: 24rpx;
                border-radius: 0;
                margin: 0;
                padding: 0 10rpx;
            }
        }   
    }
    .localtion-form-wrap{
        .input-require-tab{
            color: red;
            font-size: 20px;
            padding: 0 5rpx;
        }
        .input-wrap{
            padding: 20rpx;
            
            div{
                display: flex;
                align-items: center;
                padding-bottom: 10rpx;
                span{
                }    
            
                pre{
                    color: #bababa;
                }
            }
            
            input{
                border: 2rpx solid #ccc;
                border-radius: 5rpx;
                height: 60rpx;
                padding: 10rpx;
            }
            radio-group{
                display: flex;
                align-items: center;
            }
            .radio-item{
                margin-right: 20rpx;
            }
        }
        .input-wrap-tip{
            display: flex;
            padding-left: 20rpx;
            span{
                color: #bababa;
                
            }
        }
        .input-submit{
            color: #fff;
            background: #019788;
            margin: 0 20rpx;
            border-radius: 5rpx;
        }
        
    }

    .incorrect-info-wrap{
        background: #fff;
        padding: 20rpx;
        .incorrect-info-tip{
            color: #9b9b9b;
            padding: 20rpx 0;
        }
        .incorrect-time-wrap{
            border: 1px solid #eee;
            .incorrect-time{
                border-bottom: 1px solid #eee;
                font-size: 28rpx;
                padding: 20rpx;
                &:last-child{
                    border-bottom: none;
                }
            }   
        }
    }
}
</style>