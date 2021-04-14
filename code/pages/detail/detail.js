// pages/detail/detail.js
var common=require('../../utils/common')
const config = require("../../Config/config")
Page({
  //添加到已强订单中
  addFavorites: function(options){
    let order=this.data.order;//获取当前订单 
    wx.setStorageSync(order.id, order);//添加到本地缓存
    wx.request({
      url: config.HTTP_URL+config.GrapOrder_URL,
      method:"POST",
      header:{
        'content-type':'application/json',
      },
      data:{
        id:order.id,
        type:order.type,
        state:order.state,
        userid:order.userid,
        grapUserid:""//抢单者的userid
      }
    })
    this.setData({isAdd:true});//更新按钮显示
  },
  //取消抢单
  cancelFavorites:function(){
    let order=this.data.order;
    wx.removeStorageSync(order.id);//从本地缓存 删除
    this.setData({isAdd:false});
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
   if(order !=''){
  this.setData({isAdd:false})
   }
   //不存在
   else{
     this.setData({isAdd:true})
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