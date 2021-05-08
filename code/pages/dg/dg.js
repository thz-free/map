// pages/dg/dg.js
const config = require("../../Config/config")
Page({
  data:{
    addressContent:"8-528"
  },
  /**
   * 页面的初始数据
   */
  myAddress:function(e) {
    if(wx.getStorageSync('isregister') !=  0){
      wx.navigateTo({
        url: '/pages/shAdd/shAdd',
      })
    }else{
      wx.showToast({
        title: "请您先到个人资料注册！",
        icon:'none',
        duration:1500
      })
    }   
  },
  startAddress:function(e){
    this.checkStartAddress(e.detail.value)
  },
  destinationAddress:function(e){
    this.checkDestinationAddress(e.detail.value)
  },
  checkStartAddress:function(data){
    var reg=/\S/;
    return this.check(data,reg,'地址不能为空!')
  },
  checkDestinationAddress:function(data){
    var reg= /\S/;
    return this.check(data,reg,'收货地址不能为空!')
  },
  check:function(data,reg,errMsg){
  if(!reg.test(data)){
    wx.showToast({
      title: errMsg,
      icon:'none',
      duration:1500
    })
    return false
  }
  return true
  },
formSubmit:function(e){
  const that = this;
  if(wx.getStorageSync('isregister') !=  0){
    //console.log(e.detail.startAdd.value);
    var startAdd = e.detail.value.startAdd
    var destinationAdd = e.detail.value.destinationAdd
    var goods=e.detail.value.goods
    var userId=wx.getStorageSync('userId')
    var money=e.detail.value.money
    console.log(userId)
    console.log(startAdd+"-----"+destinationAdd)
    if(this.checkStartAddress(startAdd) && 
    this.checkDestinationAddress(destinationAdd)){
      wx.request({
        url: config.HTTP_URL+config.setDgInfo_URL,//这里是要连接的本地服务器的地址              
        data: {                
        //这里是要携带的参数  
            buyaddress:startAdd,
            buyThings:goods,
            deliveryaddress:destinationAdd,  
            user_id:userId,
            money:money  
        },              
        method:'POST',              
        header:{                
        'content-type':'application/json',    
        },success(res)
        {
            console.log(res)
            wx.showToast({
              title:'提交成功',
              icon:'success',
              duration:1500
            })
            that.setData({
              addressContent:"8-528"
            })
        }
    })
  }else{
    wx.showToast({
      title: "请您先到个人资料注册！",
      icon:'none',
      duration:1500
    })
  }
  
  }},

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