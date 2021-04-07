// pages/authorize/authorize.js
import requestUrl from '../../utils/util.js'
var globalOpenId = getApp().globalData.openId;
Page({

  /**
   * 页面的初始数据
   */
  data: {
 // 判断小程序的API，回调，参数，组件等是否在当前版本可用。
 canIUse: wx.canIUse('button.open-type.getUserInfo')//获取用户信息是否在当前版本可用
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
// 微信授权获取手机号弹窗
// getPhoneNumber (e){
//   const encryptedData = e.detail.encryptedData
//   const iv = e.detail.iv
//   console("encryptedData",encryptedData);
//   if (e.detail.encryptedData) {
//     //用户按了允许授权按钮
//     var that = this;
//     wx.login({
//       success(e) {
//         const code = e.code
//           wx.login({
//           success(e){
//            console.log("code:",e.code)
//             },
//   })
//    console.log(e);
//     //console.log(e.detail.errMsg)//包括敏感数据在内的完整用户信息的加密数据
//     console.log(e.detail.iv)//加密算法的初始向量
//     console.log(e.detail.encryptedData)//敏感数据对应的云 ID，开通云开发的小程序才会返回，可通过云调用直接获取开放数据
//         // 根据小程序返回的密钥传给后端获取真正的手机号
//         axios({
//           //url: '/wx/miniProgram/login',
//            method: "POST", 
//            data: {
//             code: code
//           }
//         }).then(({ e }) => {
//           if(e.status === 0){
//             axios({
//              // url: '/wx/miniProgram/getPhoneNumber',
//                method: "POST", 
//                data: {
//                 code: code,
//                 encryptedData: encryptedData,
//                 iv:iv
//               }
//             }).then(({ e }) => {
//                 wx.switchTab({
//                   url: '../index/index',
//                   success: (e) => {}
//               })
//             })
//           }
//         })
        
//       }
//     })
//   } else {
//     //用户按了拒绝按钮
//     wx.showModal({
//       title: '警告',
//       content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
//       showCancel: false,
//       confirmText: '返回授权',
//       success: function (e) {
//         if (e.confirm) {
//           console.log('用户点击了“返回授权”');
//         }
//       }
//     });
//   }
// },

  
 getPhoneNumber (e) {
  wx.login({
    success(e){
      console.log("code:",e.code)
    },
  })
  wx.setStorageSync('haha', e.detail.errMsg)
   console.log(e);
    console.log(e.detail.errMsg)//包括敏感数据在内的完整用户信息的加密数据

    console.log(e.detail.iv)//加密算法的初始向量
    console.log(e.detail.encryptedData)//敏感数据对应的云 ID，开通云开发的小程序才会返回，可通过云调用直接获取开放数据
    console.log("jin")
    if(e.detail.errMsg=="getPhoneNumber:ok"){//点击了“允许”按钮，
      var that=this;
      requestUrl.requestUrl({//将用户信息传给后台数据库
       // url: "/QXEV/xxx/xxx",
        // params: {
        //   openId: globalOpenId,//用户的唯一标识
        //   nickName: e.detail.userInfo.nickName,//微信昵称
        //   avatarUrl: e.detail.userInfo.avatarUrl,//微信头像
        //   province: e.detail.userInfo.province,//用户注册的省
        //   city: e.detail.userInfo.city//用户注册的市
        // },
        method: "post",
      })
        .then((data) => {//then接收一个参数，是函数，并且会拿到我们在requestUrl中调用resolve时传的的参数
            console.log("允许授权了");
        })
        .catch((errorMsg) => {
          console.log(errorMsg)
        })
        wx.switchTab({ url: '../index/index',
        })
    }
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