// pages/userInfo/userInfo.js
var config = require("../../Config/config")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    radioItems: [
      {name: '代拿', value: 'true'},
      {name: '不代拿', value: 'false', checked: 'true'},
    ]
  },
nameChange:function(e){
  this.checkName(e.detail.value)
},
studentCodeChange:function(e){
  this.checkStudentCode(e.detail.value)
},
phoneChange:function(e){
  this.checkPhone(e.detail.value)
},
checkName:function(data){
  var reg=/^[\u4e00-\u9fa5]{2,6}$/;
  return this.check(data,reg,'请正确输入姓名!')
},

checkStudentCode:function(data){
  var reg= /^[2][0][1|2][0-9]{7}$/;
  return this.check(data,reg,'学籍号输入错误!')
},
checkPhone:function(data){
  var reg=/^1[3|4|5|7|8][0-9]{9}$/;
  return this.check(data,reg,'手机号输入错误!')
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
  var name=e.detail.value.name
  var phone=e.detail.value.phone
  var studentCode=e.detail.value.studentCode
  var isDaina = e.detail.value.isDaina
  console.log("isDaina",e.detail.value)
  if(!this.checkName(name)){
    return;
  }
  if(!this.checkStudentCode(studentCode)){
    return;
  }
  if(!this.checkPhone(phone)){
    return;
  }
 // console.log(name+"-----"+phone)
 //console.log(this.checkName(name))
    /**
     * 将数据发送给后台
     */
    // 发送请求开始
    // console.log(HTTP)
    wx.request({
      url: config.HTTP_URL+config.SetUserinfo_URL,//这里是要连接的本地服务器的地址              
      data: {                
      //这里是要携带的参数  
          username:name,
          userphone:phone,
          studentCode:studentCode,
          isDaina:isDaina         
      },              
      method:'POST',              
      header:{                
      'content-type':'application/json',    
      },
      success(res){
        console.log(res)
        if(res.data.msg == "ok"){  //判断是否存储成功
          wx.setStorageSync('isRegister', true);
          wx.switchTab({
            url: '../user/user',
            success(res){
              wx.showToast({
                title: '提交成功',
                icon:'success',
                duration:1500
              },2000)
            }
          })
        }else if(res.data.msg == "exist"){
          wx.showToast({
            title: '用户已存在',
            icon:'none',
            duration:1500
          },3000)
        }else{
          wx.showToast({
            title: '提交失败',
            icon:'none',
            duration:1500
          },2000)
        }
      },
      fail(res){
        wx.hideLoading();
        wx.showModal({
          title: '网络错误',
          content: '网络出错，请刷新重试',
          showCancel: false
        })
      }
    })
      // 发送请求结束
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