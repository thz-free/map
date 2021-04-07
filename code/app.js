// app.js
import requestUrl from './utils/util.js'
App({//小程序注册
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    // 登录
    wx.login({
      success: res => {
        
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if(res.code){
          requestUrl.requestUrl({
           // url: "/QXEV/xxx/xxx",
            params:{
                 code:res.code
            },
            method:"post",
            })
            .then((data)=> {//then接收一个参数，是函数，并且会拿到我们在requestUrl中调用resolve时传的的参数
               console.log(data);//返回openId
               this.globalData.openId = res.openId;
            })
            .catch((errorMsg)=>{
              console.log(errorMsg)
            })
         }
      }
    })
  },
  globalData: {
    userInfo: "",//用户信息
    openId:"",//登录用户的唯一标识
    appid: 'wx242f88b4c25643c2',//appid  
    secret: 'e0dassda466b98dd75bac9ad5b760218075b0577def2424234209bwXXXXXXXXXXXXXX',//secret秘钥
  },
  onHide:function(){//小程序退出时触发的事件
    console.log("小程序完全退出了")
  }
})
