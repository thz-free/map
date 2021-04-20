// pages/detail/detail.js
var common=require('../../utils/common')
const config = require("../../Config/config")
Page({
  //添加到已强订单中
  addFavorites: function(options){
    const that =this;
    let order=this.data.order;//获取当前订单 
    console.log(order)
    wx.request({
      url: config.HTTP_URL+config.GrapOrder_URL,
      method:"POST",
      header:{
        'content-type':'application/json',
      },
      data:{
        id:order.id,
        grapUserid:wx.getStorageSync('userId')//抢单者的userid
      },
      success(e){
        console.log(e)
        if(e.data.result=="success"){
          that.setData({
            isAdd:true
          })
          wx.showToast({
            title: '5分钟后将不能取消订单！',
            icon: 'none',
            duration: 3000
          })
        }else{
          wx.showToast({
            title: '抢单失败！',
            icon: 'none',
            duration: 2000
          })
        }
      },
      fail(e){
        wx.showToast({
          title: '请检查网络！',
          icon: 'none',
          duration: 2000
        })
      }
    })
  },
  //取消抢单
  cancelFavorites:function(){
    const that =this;
    let order=this.data.order;//获取当前订单
    wx.request({
      url: config.HTTP_URL+config.CancelGrapOrder_URL,
      method:"POST",
      header:{
        'content-type':'application/json',
      },
      data:{
        id:order.id,
        grapUserid:wx.getStorageSync('userId')//抢单者的userid
      },
      success(e){
        console.log(e)
        if(e.data.result=="success"){
          that.setData({
            isAdd:false
          })
        }else{
          if(e.data.time == "over"){
            wx.showToast({
              title: '您抢单时间已经超过5分钟，不能取消订单！',
              icon: 'none',
              duration: 3000
            })
          }
        }
      }
    })
  },
  /**
   * 页面的初始数据
   */
  data: {
      
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   let id=options.id;
   let result=common.getOrderDetail(id)
   if(result.code=='200'){
     this.setData({order:result.order})
   }
   //检查当前订单是否在已接单中
   var order=wx.getStorageInfoSync(id);
  //已存在 
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
    wx.showLoading({
      title: '加载中',
      })
    setTimeout(function () {
      wx.hideLoading()
      }, 700)
    let order=this.data.order;
    const that = this;
    wx.request({
      url: config.HTTP_URL+config.OrderState_URL,
      method:"POST",
      header:{
        'content-type':'application/json',
      },
      data:{
        id:order.id,
      },
      success(e){
        console.log(e)
        if(e.data.state){
            that.setData({isAdd:e.data.state})
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