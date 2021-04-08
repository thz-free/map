// pages/authorize/authorize.js
const config = require("../../Config/config");
import requestUrl from '../../utils/util.js'
var globalOpenId = getApp().globalData.openId;
Page({

  /**
   * 页面的初始数据
   */
  data: {
 // 判断小程序的API，回调，参数，组件等是否在当前版本可用。
 canIUse: wx.canIUse('button.open-type.getUserInfo')//获取用户信息是否在当前版本可用
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
 getPhoneNumber (e) { 
    //console.log("iv:",e.detail.iv)//加密算法的初始向量
    //console.log("encryptedData:",e.detail.encryptedData)//敏感数据对应的云 ID，开通云开发的小程序才会返回，可通过云调用直接获取开放数据
    const iv = e.detail.iv;
    const encryptedData = e.detail.encryptedData;
    const detail = e.detail;
    if(e.detail.errMsg=="getPhoneNumber:ok"){//点击了“允许”按钮，
      wx.login({
        success(e){
          wx.request({
            url: config.HTTP_URL+config.AuthorizeLogin_URL,
            method:"POST",
            data:{
              appid:config.appid,
              encryptedData:encryptedData,
              iv:iv,
              secret:config.secret,
              code:e.code
            },
            success(e){
              if(e.data.msg == "ok") {
                wx.setStorageSync('errMsg', detail.errMsg);
                wx.setStorageSync('wxphone', e.data.wxphone);
                wx.switchTab({ url: '../index/index'});
              }
            },
            fail(e){
              console.log("获取异常！")
            }
          })
          //console.log(e.code);
        }
      })
    }
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