<template>
  <div>
  <div class="share">
    <text class="stxt" @click="text">文本分享</text>
  </div>

   <div class="share">
    <text class="stxt" @click="img">图片分享</text>
  </div>

   <div class="share">
    <text class="stxt" @click="music">音乐分享</text>
  </div>

   <div class="share">
    <text class="stxt" @click="video">视频分享</text>
  </div>

   <div class="share">
    <text class="stxt" @click="webpage">网页分享</text>
  </div>
  </div>
 
</template>
<script>
  var share=weex.requireModule('sharemodule');
  

  var textShare={scene:1,title:'标题',
  descrption:'描述','text':"大家好"};

   var imageShare={
    scene:0,title:'标题',sharetype:2,
    'thumb':"https://f11.baidu.com/it/u=3370260265,1231552087&fm=72",
   descrption:'描述','text':"hellorold",'img':"https://f11.baidu.com/it/u=3370260265,1231552087&fm=72"};

   var webShare={
    scene:1,title:'标题web',sharetype:5,
     'thumb':"https://f11.baidu.com/it/u=3370260265,1231552087&fm=72",
   descrption:'描述web','weburl':"https://www.sxnxl.com/wap"};

  module.exports = {
   
    methods: {
      text: function() {

        share.share(1,textShare);
        alert.toast({
          message: 'This is a toast',
          duration: 0.3
        })

      },
      img: function() {
        share.share(1,imageShare);
        // share.share('1',{});

      },
      music: function() {
        // share.share('1',{});

      },
      video: function() {
        // share.share('1',{});

      },
      webpage: function() {
          share.share('1',webShare);

      }

    }
  }
</script>
<style scoped>
  .stxt{
     text-align: center;
     line-height: 50px;
     font-size: 50px;

  }
  .share{
    width: 750px;
    height: 100px;
    border-width: 2px;
   
  }
</style>