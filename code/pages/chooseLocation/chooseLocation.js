const city = require("../../utils/allcity")
var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js');
var City = require('../../utils/allcity')
var qqmapsdk = new QQMapWX({
      key:'3YOBZ-5BQKX-TNF4K-ZQZ76-WBVLT-HQFRZ'
});
// pages/chooseLocation/chooseLocation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      city:wx.getStorageSync('city'),
      isBack:true,
      chooseCity:"",
      name:"",
      isto:"",
      detailedLocation:"",
  },
  setMessage(e){
    console.log(e.currentTarget.dataset.index)
    console.log("message",wx.getStorageSync('detailedLocation'))
    let index = e.currentTarget.dataset.index;
    let detailed = wx.getStorageSync('detailedLocation')
    wx.setStorageSync('detailed', detailed[index])
    wx.setStorageSync('ischoose', false)
    wx.navigateBack({
      url:"../userLocationMap/userLocationMap",
    })
  },
  chooseCity(e){
      wx.navigateTo({
        url: '../chooseCity/chooseCity',
      })
  },
  input(options){
    if(options.detail.value == ""){
      return;
    }
    // console.log("options",options.detail)
    if(this.data.name == ""){
      
        var name = "益阳市"  //定位的城市
        var value = options.detail.value
      
    }else{
      var name = this.data.name  //定位的城市
      var value = options.detail.value
      this.onShow
    }
    const data={
      "region":name,
      "keyword":value,
      "page_index":1,
      "page_size":20
    }
    wx.serviceMarket.invokeService({
      service: 'wxc1c68623b7bdea7b',
      api: 'poiSuggestion',
      data:data
    }).then(e=>{
      //存储搜索响应数据开始
      let pois = '';
      let result = (typeof e.data) === 'string' ? JSON.parse(e.data) : e.data;
      let markers = []; //设置marker
      let includePoints = []; //设置包含点
      // console.log(result)
      if(options.detail.value != ""){
      for (let i = 0; i < result.data.length; i++) {
        markers.push({
          id: i,
          latitude: result.data[i].location.lat,
          longitude: result.data[i].location.lng,
          iconPath: `https://3gimg.qq.com/lightmap/xcx/demoCenter/images/Marker1_Activated@3x.png`,
          width: 34,
          height: 34
        });
        includePoints.push({
          latitude: result.data[i].location.lat,
          longitude: result.data[i].location.lng,
        });
      };
      this.setData({
        markers: markers,
        includePoints: includePoints,
        resultJson: [{
          name: 'pre',
          children: [{
            type: 'text',
            text: (typeof e.data) === 'string' ? e.data : JSON.stringify(e.data, null, '\t')
          }]
        }],
        pois: result.data
      });
    }else{
      console.log("options",options.detail)
      const data = {
        "keyword":value,
        "boundary":`region(${name})`,  //neaeby(参数)
        "page_index":1,
        "page_size":20
      }
      // console.log("keyword",data.keyword);
      // console.log("boundary",data.boundary);
        wx.serviceMarket.invokeService({
          service: 'wxc1c68623b7bdea7b',
          api: 'poiSearch',
          data: data
        }).then(e=>{
          // console.log(e.data);
  
          // // 发送请求开始
          // wx.request({
          //   url: 'http://192.168.1.103:8080/setLocaltion',//这里是要连接的本地服务器的地址              
          //   data: {                
          //   //这里是要携带的参数  
          // "data":e.data         
          //   },              
          //   method:'POST',              
          //   header:{                
          //   'content-type':'application/json',
          //   'x-token':""//这里是连接需要的token令牌 不需要请忽略              
          //   }})
          //   // 发送请求结束
  
            //存储搜索响应数据开始
            let pois = '';
            let result = (typeof e.data) === 'string' ? JSON.parse(e.data) : e.data;
            let markers = []; //设置marker
            let includePoints = []; //设置包含点
            for (let i = 0; i < result.data.length; i++) {
              markers.push({
                id: i,
                latitude: result.data[i].location.lat,
                longitude: result.data[i].location.lng,
                iconPath: `https://3gimg.qq.com/lightmap/xcx/demoCenter/images/Marker1_Activated@3x.png`,
                width: 34,
                height: 34
              });
              includePoints.push({
                latitude: result.data[i].location.lat,
                longitude: result.data[i].location.lng,
              });
            };
            this.setData({
              markers: markers,
              includePoints: includePoints,
              resultJson: [{
                name: 'pre',
                children: [{
                  type: 'text',
                  text: (typeof e.data) === 'string' ? e.data : JSON.stringify(e.data, null, '\t')
                }]
              }],
              pois: result.data
            });
            // 存储搜索响应数据结束
        })
    }
      // console.log("e:",e)
    }).catch(err=>{
      console.log(err)
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
  onShow: function (options) {
    /**
     * 获取当前地点
     */
    wx.getLocation({
      type: 'wgs84',
      success(res){
        qqmapsdk.reverseGeocoder({
          success:function(res){
            let city = res.result.address_component.city;
            // console.log("city:",city)
            wx.setStorageSync('city', city)
          }
        })
      },
    })
    //  console.log("option",this.data)
    if(this.data.name == ""){
      var city = this.data.city
    }else{
      var city = this.data.name
    }
    // console.log("city:",city)

    wx.showLoading({
      title: '加载中',
    })
    setTimeout(function () {
      wx.hideLoading()
    }, 800)
    
    const data = {
      "keyword":"学校",
      "boundary":`region(${city})`, //nearby(参数)
      "page_index":1,
      "page_size":20
    }

    //console.log("keyword",data.keyword);
    // console.log("boundary",data.boundary);
      wx.serviceMarket.invokeService({
        service: 'wxc1c68623b7bdea7b',
        api: 'poiSearch',
        data: data
      }).then(e=>{
        // console.log(e.data.data);
        wx.setStorageSync('detailedLocation', e.data.data)

        // 发送请求开始
        // wx.request({
        //   url: 'http://192.168.1.103:8080/setLocaltion',//这里是要连接的本地服务器的地址              
        //   data: {                
        //   //这里是要携带的参数  
        // "data":e.data         
        //   },              
        //   method:'POST',              
        //   header:{                
        //   'content-type':'application/json',
        //   'x-token':""//这里是连接需要的token令牌 不需要请忽略              
        //   }})
        //   // 发送请求结束

          //存储搜索响应数据开始
          let pois = '';
          let result = (typeof e.data) === 'string' ? JSON.parse(e.data) : e.data;
          let markers = []; //设置marker
          let includePoints = []; //设置包含点
          for (let i = 0; i < result.data.length; i++) {
            markers.push({
              id: i,
              latitude: result.data[i].location.lat,
              longitude: result.data[i].location.lng,
              iconPath: `https://3gimg.qq.com/lightmap/xcx/demoCenter/images/Marker1_Activated@3x.png`,
              width: 34,
              height: 34
            });
            includePoints.push({
              latitude: result.data[i].location.lat,
              longitude: result.data[i].location.lng,
            });
          };
          this.setData({
            markers: markers,
            includePoints: includePoints,
            resultJson: [{
              name: 'pre',
              children: [{
                type: 'text',
                text: (typeof e.data) === 'string' ? e.data : JSON.stringify(e.data, null, '\t')
              }]
            }],
            pois: result.data
          });
          // 存储搜索响应数据结束
          // console.log("thisData",this.data);
      }).catch(err => {
        wx.showLoading({
          title: '加载中',
        })
        setTimeout(function () {
          wx.hideLoading(
          )
          wx.showModal({
            title: '提示',
            content: '请检查网络',
            success (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
          })
        }, 1000)
        
      }); 
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