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
      if(wx.getStorageSync('isregister') !=  0){
        wx.navigateTo({
          url: '/pages/dn/dn',
          })
      }else{
        wx.showModal({
          title: '提示',
          content: '请您先注册!',
          confirmText:'注册',
          success (res) {
            if (res.confirm) {
              console.log('用户点击注册')
              wx.navigateTo({
                url: '/pages/userInfo/userInfo',
                })
            } else if (res.cancel) {
              console.log('用户点击取消')
            }
          }
        })
      }
    },
  dg:function(e){
      if(wx.getStorageSync('isregister') !=  0){
        wx.navigateTo({
          url: '/pages/dg/dg',
          })
      }else{
        wx.showModal({
          title: '提示',
          content: '请您先注册!',
          confirmText:'注册',
          success (res) {
            if (res.confirm) {
              console.log('用户点击注册')
              wx.navigateTo({
                url: '/pages/userInfo/userInfo',
                })
            } else if (res.cancel) {
              console.log('用户点击取消')
            }
          }
        })
      }
    },
  db:function(e){
      if(wx.getStorageSync('isregister') !=  0){
        wx.navigateTo({
          url: '/pages/db/db',
          })
      }else{
        wx.showModal({
          title: '提示',
          content: '请您先注册!',
          confirmText:'注册',
          success (res) {
            if (res.confirm) {
              console.log('用户点击注册')
              wx.navigateTo({
                url: '/pages/userInfo/userInfo',
                })
            } else if (res.cancel) {
              console.log('用户点击取消')
            }
          }
        })
      }
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
  }
})
