// pages/publish/publish.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
       num:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
     //获取已接订单列表
     this.getMyFavorites();
  },
//获取已抢订单列表
getMyFavorites:function(){
  let info=wx.getStorageInfoSync();//读取本地缓存信息
  let keys=info.keys; //获取全部keys信息
  let num=keys.length;//获取已接订单数量
  let myList=[];
  for(var i=0;i<num;i++){
    let obj=wx.getStorageSync(keys[i]);
    myList.push(obj); 
  }
  //更新列表
  this.setData({
   orderList:myList,
    num:num
  });
},
goToDetail:function(e){
  let id=e.currentTarget.dataset.id;
  wx.navigateTo({
    url: '../orderDetail/orderDetail?id='+id,
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