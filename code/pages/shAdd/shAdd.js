var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js');
var qqmapsdk = new QQMapWX({
      key:require("../../Config/config").key
});
// pages/shAdd/shAdd.js
const config = require("../../Config/config")
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  addAddress(e){
    console.log(e.currentTarget.dataset.address);
    const address = e.currentTarget.dataset.address;
    var pages = getCurrentPages();
    var prevPage = pages[pages.length - 2];
    prevPage.setData({
      address:address,
      addressContent:address.location+address.address
    }),
    wx.navigateBack({
      url:"../dn/dn",
    })
  },
  tap(e){
      wx.navigateTo({
        url: '../userLocationMap/userLocationMap',
      })
  },
  updatelocation(e){
    // console.log(e.currentTarget.dataset)
    wx.setStorageSync('address', e.currentTarget.dataset.address)
    wx.navigateTo({
      url: '../locationinfo/locationinfo'
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      //获取当前城市
      wx.getLocation({
        type: 'wgs84',
        success (res) {
          qqmapsdk.reverseGeocoder({
            success:function(res){
              console.log(res)
              let city = res.result.address_component.city;
              wx.setStorageSync('city', city);
              console.log(city)
            }
          })
        }
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
    const that = this;
      wx.request({
        url: config.HTTP_URL+config.GetTakeAddress_URL,
        method:"POST",
        data:{
          userid:wx.getStorageSync('userId')
        },
        header:{                
          'content-type':'application/json',             
        },
        success(res){
          // console.log("收货地址信息：",res.data)
          that.setData({
            address:res.data.takeAddressList
          })
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