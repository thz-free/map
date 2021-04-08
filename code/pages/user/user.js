// pages/user/user.js
const config = require("../../Config/config")
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  //获取用户信息
getMyInfo:function(e){
   let info=e.detail.userInfo;
   this.setData({
     isLogin:true,  //确认登录状态
     src:info.avatarUrl, //更新图片来源
     nickName:info.nickName //更新昵称
   })
},
//个人资料点击跳转
info:function(e){

  if(wx.getStorageSync('isregister')){
    wx.navigateTo({
      url: '/pages/userinfoList/userinfoList',
    })
  }else{
    wx.navigateTo({
      url: '/pages/userInfo/userInfo',
    })
  }
},
orderSearch:function(e){
  wx.navigateTo({
    url: '/pages/orderSearch/orderSearch',
  })
},
publish:function(e){
  wx.navigateTo({
    url: '/pages/publish/publish',
  })
},
service:function(e){
  wx.navigateTo({
    url: '/pages/service/service',
  })
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    wx.request({
      url: config.HTTP_URL+config.IsRegister_URL,
      method:"POST",
      data:{
        wxphone:wx.getStorageSync('wxphone')
      },
      success(e){
        //console.log(e)
        //判断是否注册
        if(e.data.isregister){
          wx.setStorageSync('isregister', true)
        }else{
          wx.setStorageSync('isregister', false)
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})