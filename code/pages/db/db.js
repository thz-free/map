// pages/db/db.js
var config=require("../../Config/config")
Page({
startAddress:function(e){
    this.checkStartAddress(e.detail.value)
  },
nameChange:function(e){
    this.checkNameChange(e.detail.value)
  },
timeChange:function(e){
    this.checkTimeChange(e.detail.value)
  },
checkStartAddress:function(data){
    var reg=/\S/;
    return this.check(data,reg,'地址不能为空!')
  },
checkNameChange:function(data){
    var reg= /\S/;
    return this.check(data,reg,'事务名称不能为空!')
  },
checkTimeChange:function(data){
    var reg= /\S/;
    return this.check(data,reg,'时间不能为空!')
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
    //console.log(e.detail.startAdd.value);
    var startAdd = e.detail.value.startAdd
    var time = e.detail.value.time
    var name=e.detail.value.name
    var userId=wx.getStorageSync('userId')
    var money=e.detail.value.money
    if(this.checkStartAddress(startAdd) && 
    this.checkNameChange(name) && this.checkTimeChange(time)){
      wx.request({
        url: config.HTTP_URL+config.setDbInfo_URL,//这里是要连接的本地服务器的地址              
        data: {                
        //这里是要携带的参数  
        dbaffairs:name,
        dbtime:time,
        dbaddress:startAdd,
        user_id:userId, 
        money:money   
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
            wx.switchTab({
              url: '../index/index',
            })
        },
        fail(res){
          wx.hideLoading();
          wx.switchTab({
            url: '../index/index',
          })
          wx.showModal({
            title: '网络错误',
            content: '网络出错，请刷新重试',
            showCancel: false
          })
        }
      
      })
    }
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