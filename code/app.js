// app.js
const config = require("./Config/config")
App({//小程序注册
  
  onLaunch (options) {
    // Do something initial when launch.
    wx.login({
      success(e){
        wx.request({
          url: config.HTTP_URL+config.AuthorizeLogin_URL,
          method:"POST",
          data:{
            appid:config.appid,
            secret:config.secret,
            code:e.code
          },
          success(e){
            if(e.data.msg == "ok") {
              wx.setStorageSync('openid', e.data.openid);
              wx.setStorageSync('isRegister', true) //是否授权
              if(wx.getStorageSync('isRegister') == true){
                //获取存储的数据开始,防止注册后要重新进入个人信息
                wx.request({
                 url: config.HTTP_URL+config.GetUserinfo_URL,
                 method:'POST', 
                 data:{
                   openid:wx.getStorageSync('openid')
                 } ,            
                 header:{                
                 'content-type':'application/json',       
                 },
                 success(res){
                   console.log("用户信息:",res)
                   const data = res.data.userinfo;
                   wx.setStorageSync('isregister', data.isregister);
                   wx.setStorageSync('userId', data.userid);
                   console.log("data.isregister:",wx.getStorageSync('isregister'))
                   console.log("userId:",data)
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
             //获取存储的数据结束                       
             }
            }
          },
          fail(e){
            console.log("获取异常！")
          }
        })
        console.log(e)
      }
    })
  }
})
