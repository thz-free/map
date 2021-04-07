// pages/userLocationMap/userLocationMap.js
const config = require("../../Config/config")

Page({

  /**
   * 页面的初始数据
   */
  data: {
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
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    let locationinfo = e.detail.value
    if(this.data.message == "" || locationinfo.username == "" || locationinfo.address == "" || locationinfo.tel == ""){
      wx.showToast({
        title: '请您填写全部信息！',
        icon:"none"
      })
      return;
    }
    wx.request({
      url: config.HTTP_URL+config.UpdateTakeAddress_URL,
      method:"POST",
      header:{                
        'content-type':'application/json',             
      },
      data:{
        username:locationinfo.username,
        address:locationinfo.address,
        phone:locationinfo.phone,
        location:locationinfo.location,
        sex:locationinfo.sex,
        id:this.data.id
      },
      success(res){
        console.log(res)
        if(res.data.msg != "ok"){
          wx.showToast({
            title: '保存失败！',
            icon:"none"
          })
          return;
        }
        wx.navigateBack({
          delta:1,
        }),
        wx.showToast({
          title: '保存成功！',
          icon:"none"
        })
      }
    })
    // console.log("userinfo:",data)
  },
  //删除
  delete(res){
    wx.request({
      url: config.HTTP_URL+config.DeleteTakeAddress_URL,
      method:"POST",
      header:{                
        'content-type':'application/json',             
      },
      data:{
        id:this.data.id
      },
      success(res){
        if(res.data.msg != "ok"){
          wx.showToast({
            title: '删除失败！',
            icon:"none"
          })
          return;
        }
        wx.navigateBack({
          delta:1,
        })
        wx.showToast({
          title: '删除成功！',
          icon:"none"
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
      console.log(wx.getStorageSync('address'))
      const address = wx.getStorageSync('address');
      if (address.sex == "先生") {
        this.setData({
          radioItems:[
            {name: '先生', value: '先生', checked: 'true'},
            {name: '女士', value: '女生'}
          ]
        })
      }else{
        this.setData({
          radioItems:[
            {name: '先生', value: '先生'},
            {name: '女士', value: '女生', checked: 'true'}
          ]
        })
      }
      this.setData({
        address:address.address,
        phone:address.phone,
        location:address.location,
        id:address.id,
        username:address.username
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