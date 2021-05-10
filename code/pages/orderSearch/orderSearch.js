// pages/orderSearch/orderSearch.js
const config = require("../../Config/config")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    num:0
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
     //获取已接订单列表
 this.getMyFavorites();

  },
//获取已抢订单列表
getMyFavorites:function(){
  let info=wx.getStorageInfoSync();//读取本地缓存信息
  let keys=info.keys; //获取全部keys信息
  let num=keys.length;//获取已接订单数量
  let myList=[];
  for(var i=0;i<num;i++){
    let obj=wx.getStorageSync(keys[i]);
    myList.push(obj); 
  }
},
goToDetail:function(e){
  console.log(e)
  let orderid = e.currentTarget.dataset.orderid;
  wx.navigateTo({
    url: '../orderDetail/orderDetail?id='+orderid,
  })
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
    const that = this;
    wx.request({
      url: config.HTTP_URL+config.SearchGrapOrder_URL,
      method:"POST",
      header:{
        'content-type':'application/json',
      },
      data:{
        grapuser_id:wx.getStorageSync('userId')//抢单者的userid
      },
      success(e){
        console.log(e)
        that.setData({
          orderList:e.data.graporders,
           num:e.data.graporders.length
         });
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