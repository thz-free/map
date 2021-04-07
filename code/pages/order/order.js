// pages/order/order.js
var common=require('../../utils/common')
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
goToDetail:function(e){
  //获取携带的data-id数据
  let id=e.currentTarget.dataset.id;
  //携带id页面进行页面跳转
  wx.navigateTo({  
    url: '../detail/detail?id='+id
  })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
//获取列表
let list = common.getOrderList()
//更新列表数据
this.setData({orderList:list})
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