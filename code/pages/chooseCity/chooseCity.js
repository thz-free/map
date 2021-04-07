// pages/demo/demo.js
var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js');
var City = require('../../utils/allcity')
var qqmapsdk = new QQMapWX({
      key:'3YOBZ-5BQKX-TNF4K-ZQZ76-WBVLT-HQFRZ'
});
Page({
  data: {
    city: [],
    config: {
      horizontal: true, // 第一个选项是否横排显示（一般第一个数据选项为 热门城市，常用城市之类 ，开启看需求）
      animation: true, // 过渡动画是否开启
      search: true, // 是否开启搜索
      searchHeight: 45, // 搜索条高度
      suctionTop: true // 是否开启标题吸顶
    }
  },
  onLoad() {
    wx.showLoading({
      title: '加载数据中...',
      
    })
    // 模拟服务器请求异步加载数据
    setTimeout(()=>{
    this.setData({
      city: City
    })
      wx.hideLoading()
    },1000)

  },
  bindtap(e) {
    // console.log("detail:",e.detail)
    let chooseCity = e.detail.name; 
    var pages = getCurrentPages();
    var prevPage = pages[pages.length - 2];
    prevPage.setData({
      chooseCity:chooseCity,
      isBack:false,
      name:e.detail.name,
      isto:true
    })
    wx.navigateBack({
      url:"../chooseLocation/chooseLocation"
    })
  },

})