// 获取应用实例
const app = getApp()
const config = require("../../Config/config")
Page({//注册当前页面
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
  },
  dn:function(e){
    wx.navigateTo({
    url: '/pages/dn/dn',
    })
    },
  dg:function(e){
     wx.navigateTo({
     url: '/pages/dg/dg',
    })
    },
  db:function(e){
      wx.navigateTo({
      url: '/pages/db/db',
     })
     },
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad() {
  },
  onShow(){
    if(wx.getStorageSync('isRegister') == true){
       //获取存储的数据开始,防止注册后要重新进入个人信息
       wx.request({
        url: config.HTTP_URL+config.GetUserinfo_URL,
        method:'POST', 
        data:{
          wxphone:wx.getStorageSync('wxphone')
        } ,            
        header:{                
        'content-type':'application/json',       
        },
        success(res){
          //console.log("用户信息:",res)
          const data = res.data.userinfo;
          wx.setStorageSync('userId', data.userid);
          //console.log("获取的数据",res)
        },
        fail(res){
          wx.hideLoading();
          wx.showModal({
            title: '网络错误',
            content: '网络出错，请刷新重试',
            showCancel: false
          })
        }
      })
    //获取存储的数据结束                       
    }

    //console.log(this.data)
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    var that = this;
    var haha = wx.getStorageSync('errMsg')
    // 判断是否已经授权
    wx.getSetting({
      success: (e) => {
        if (haha == "getPhoneNumber:ok") {//授权了，可以获取用户信息了
          wx.getUserInfo({
            success: (e) => {
              //console.log(e)
            }
          })
        }else{//未授权，跳到授权页面
          wx.redirectTo({
            url: '../authorize/authorize',//授权页面
          })
        }
      }
    })
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
