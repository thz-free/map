const config = require('../../Config/config');
// pages/order/order.js
var common=require('../../utils/common')
Page({
     
  /**
   * 页面的初始数据
   */
  data: {
       orderList:{}
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
// this.setData({orderList:list})
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  
  dn:  function(e){
    const that = this;
    var str=e.currentTarget.dataset.id;
    console.log(str);
    wx.request({
      url: config.HTTP_URL+config.FindByType_URL,
      data:{
        type:str
      },
      method:'GET',
      header:{
        'content-type':'application/json',
      },
      success(res)
      {
        console.log(res)
       
        that.setData(
          {
            listLength:res.data.length,
            orderList:res.data
          }
        )
      }
    })
  },
  
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    const that = this;
    wx.request({
      url: config.HTTP_URL+config.FindByType_URL,
      data:{
        type:0
      },
      method:'GET',
      header:{
        'content-type':'application/json',
      },
      success(res)
      {
        console.log(res)
        that.setData(
          {
            listLength:res.data.length,
            orderList:res.data
          }
        )
      }
    })
    if(wx.getStorageSync('isregister') ==  0){
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
            wx.switchTab({
              url: '/pages/index/index',
              })
            console.log('用户点击取消')
          }
        }
      })
    }
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