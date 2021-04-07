// pages/userinfoList/userinfoList.js
var config = require("../../Config/config")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:"",
    studentCode:"",
    userphone:""
  },
  formSubmit:function(e){
    console.log(e)
    var name=e.detail.value.username
    var phone=e.detail.value.userphone
    var studentCode=e.detail.value.studentCode
    var isDaina = e.detail.value.daina
    wx.request({
      url: config.HTTP_URL+config.UpdateUserinfo_URL,//这里是要连接的本地服务器的地址              
      data: {                
      //这里是要携带的参数  
          username:name,
          userphone:phone,
          studentCode:studentCode,
          isDaina:isDaina,
          id:wx.getStorageSync('userId')         
      },              
      method:'POST',              
      header:{                
      'content-type':'application/json',             
      },
      success(res){
        console.log(res)
        if(res.data.msg == "ok"){  //判断是否存储成功
          wx.switchTab({
            url: '../user/user',
            success(res){
              wx.showToast({
                title: '保存成功',
                icon:'success',
                duration:1500
              },2000)
            }
          })
        }else{
          wx.showToast({
            title: '保存失败',
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
    const that = this;
      wx.request({
        url: config.HTTP_URL+config.GetUserinfo_URL,
        method:'POST',              
        header:{                
        'content-type':'application/json',       
        },
        success(res){
          const data = res.data.userinfoList[0];
          wx.setStorageSync('userId', data.id);
          if(data.daina){
            that.setData({
              username:data.username,
              studentCode:data.studentCode,
              userphone:data.userphone,
              radioItems: [
                {name: '代拿', value: 'true',checked:'true'},
                {name: '不代拿', value: 'false'},
              ]
            })
          }else{
            that.setData({
              username:data.username,
              studentCode:data.studentCode,
              userphone:data.userphone,
              radioItems: [
                {name: '代拿', value: 'true'},
                {name: '不代拿', value: 'false',checked:'true'}
              ]
            })
          }
          console.log("获取的数据",res)
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