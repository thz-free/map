// pages/userLocationMap/userLocationMap.js
const config = require("../../Config/config")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ischoose:true,
    message:"",
    isBack:true,
    city:'',
    detailed:"",
    chooseCity:'',
    radioItems: [
      {name: '先生', value: '先生', checked: 'true'},
      {name: '女士', value: '女生'}
    ],
  },
  ak(e){
      wx.navigateTo({
        url: '../chooseLocation/chooseLocation',
      })
  },
  /**
   * 
   *  表单提交 
   */
  formSubmit(e) {
    // console.log('form发生了submit事件，携带数据为：', e.detail.value)
    let locationinfo = e.detail.value
    if(this.data.message == "" || locationinfo.username == "" || locationinfo.address == "" || locationinfo.tel == ""){
      wx.showToast({
        title: '请您填写全部信息！',
        icon:"none"
      })
      return;
    }
    wx.request({
      url: config.HTTP_URL+config.SetTakeAddress_URL,
      data:{
        username:locationinfo.username,
        address:locationinfo.address,
        phone:locationinfo.tel,
        location:this.data.message,
        sex:locationinfo.sex,
        userid:wx.getStorageSync('userId')
      },
      method:'POST',              
      header:{                
      'content-type':'application/json',             
      },
      success(res){
        console.log("地址后台返回数据:",res)
        if(res.data.msg == "ok"){  //判断是否存储成功
          wx.navigateBack({
            url: '../shAdd/shAdd',
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
  onReady: function (options) {
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function (options) {
     console.log(this.data.ischoose)
     console.log(this.data)
    if(!this.data.ischoose){
      wx.setStorageSync('ischoose', true)
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