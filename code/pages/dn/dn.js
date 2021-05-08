// pages/dn/dn.js
const config = require("../../Config/config")
Page({
  data:{
    addressContent:"8-528"
  },
//选择地址
myAddress:function(e) {
  wx.navigateTo({
    url: '/pages/shAdd/shAdd',
  })
  
},
//选择图片
chooseImage:function(){
 var that=this
 wx.chooseImage({
   count: 1,//默认为9
   sizeType:['original','compressed'],//指定是原图还是压缩图
   sourceType:['album','camera'],//指定相册还是相机
   success:function(res){
     var tempFilePaths=res.tempFilePaths
     that.setData({src:tempFilePaths[0]})
   }
 })
},
startAddress:function(e){
  this.checkStartAddress(e.detail.value)
  console.log(e.detail.value);
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
  if(wx.getStorageSync('isregister') !=  0){
    var startAdd = e.detail.value.startAdd
    var destinationAdd = e.detail.value.destinationAdd
    var userId=wx.getStorageSync('userId')
    var money=e.detail.value.money
    var dnNumber=e.detail.value.dnNumber
    var that = this;
    if(this.checkStartAddress(startAdd) && this.checkDestinationAddress(destinationAdd)){
      wx.request({
        url: config.HTTP_URL+config.setDnInfo_URL,//这里是要连接的本地服务器的地址              
        data: {                
        //这里是要携带的参数  
            kdAddress:startAdd,
            deliveryaddress:destinationAdd,
            user_id:userId,  
            money:money,
            dnNumber:dnNumber  
        },              
        method:'POST',              
        header:{                
        'content-type':'application/json',    
        },
        success(res)
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
    console.log("代拿data信息：",this.data)
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