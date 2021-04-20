const order=[{
  id:1,
  title:'8-321代拿快递',
  content:'3月25日下午，8-321需要在校园物流代拿快递一件'
},
{
  id:2,
  title:'2-321代办',
  content:'4月19号，去一教拿个东西'
},
{
  id:3,
  title:'5-321代拿快递',
  content:'3月25日下午，8-321需要在校园物流代拿快递一件'
}
];
//获取订单列表
function getOrderList(){
  let list=[];
  for(var i=0;i<order.length;i++){
    let obj={};
    obj.id=order[i].id;
    obj.title=order[i].title;
    list.push(obj);
  }
  return list;
}
//获取订单内容
function getOrderDetail(orderID){
  let msg ={
    code:'404',//没有对应的订单 
    order:{}
  };
  for(var i=0;i<order.length;i++){
    if(orderID==order[i].id){
      let obj={};
     msg.code='200'//成功
     msg.order=order[i];//更新当前新闻内容
     break;
    }
  }
  return msg;
}
//对外暴露的接口
module.exports={
  getOrderList:getOrderList,
  getOrderDetail:getOrderDetail
}