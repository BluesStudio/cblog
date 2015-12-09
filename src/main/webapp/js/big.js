//index
$(function(){
  $(".bimg").click(function(){
    var _this = $(this);
    imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
  });
});
function imgShow(outerdiv, innerdiv, bigimg, _this){
  var src = _this.attr("src");
  $(bigimg).attr("src", src);
  $("<img/>").attr("src", src).load(function(){
    var windowW = $(window).width();
    var windowH = $(window).height();
    var realWidth = this.width;
    var realHeight = this.height;
    var imgWidth, imgHeight;
    var scale = 0.8;
    if(realHeight>windowH*scale) {
      imgHeight = windowH*scale;
      imgWidth = imgHeight/realHeight*realWidth;
      if(imgWidth>windowW*scale) {
        imgWidth = windowW*scale;
      }
    } else if(realWidth>windowW*scale) {
      imgWidth = windowW*scale;
      imgHeight = imgWidth/realWidth*realHeight;
    } else {
      imgWidth = realWidth;
      imgHeight = realHeight;
    }
    imgWidth = Math.ceil(imgWidth);
    imgHeight = Math.ceil(imgHeight);
    $(bigimg).css("width",imgWidth);
    var w = (windowW-imgWidth)/2;
    var h = (windowH-imgHeight)/2;
    $(innerdiv).css({"top":h, "left":w});
    $(outerdiv).fadeIn("fast");
  });
  $(outerdiv).click(function(){
    $(this).fadeOut("fast");
  });
}


//members
$(function(){
    $(".mimg").click(function(){
        var _this = $(this);
        boxShow("#outerdiv", "#black_overlay", "#innerdiv", "#members-said", "#simg", _this, "#closesaid");
    });
});
function boxShow(outerdiv, black, innerdiv, sbox, simg, _this, close){
  var src = _this.attr("src");
  $(simg).attr("src", src);
  $(function(){
    var windowW = $(window).width();
    var windowH = $(window).height();
    var boxWidth = $(sbox).width();
    var boxHeight = $(sbox).height();
    var w = (windowW-boxWidth)/2;
    var h = (windowH-boxHeight)/2;
    $(innerdiv).css({"top":h, "left":w});
    $(outerdiv).fadeIn("fast");
  });
  $(black).click(function(){
    $(outerdiv).fadeOut("fast");
  });
  $(close).click(function(){
    $(outerdiv).fadeOut("fast");
  });
}


//album
$(function(){
    $(".cimg").click(function(){
        var _this = $(this);
        imgboxShow("#outerdiv", "#black_overlay", "#innerdiv", "#bigimg", _this, "#closesaid");
    });
    $(".dimg").click(function(){
        var _this = $(this);
        imgboxShow("#outerdiv", "#black_overlay", "#innerdiv", "#bigimg", _this, "#closesaid");
    });
});
function imgboxShow(outerdiv, black, innerdiv, bigimg, _this, close){
  var src = _this.attr("src");
  $(bigimg).attr("src", src);
  $("<img/>").attr("src", src).load(function(){
    var windowW = $(window).width();
    var windowH = $(window).height();
    var realWidth = this.width;
    var realHeight = this.height;
    var imgWidth, imgHeight;
    var scale = 0.8;
    if(realHeight>windowH*scale) {
      imgHeight = windowH*scale;
      imgWidth = imgHeight/realHeight*realWidth;
      if(imgWidth>windowW*scale) {
        imgWidth = windowW*scale;
      }
    } else if(realWidth>windowW*scale) {
      imgWidth = windowW*scale;
      imgHeight = imgWidth/realWidth*realHeight;
    } else {
      imgWidth = realWidth;
      imgHeight = realHeight;
    }
    imgWidth = Math.ceil(imgWidth);
    imgHeight = Math.ceil(imgHeight);
    $(bigimg).css("width",imgWidth);
    $(".album-dicuss").css("height",imgHeight - 90);//album-dicuss评论框
    var w = (windowW-imgWidth)/2;
    var h = (windowH-imgHeight)/2;
    $(innerdiv).css({"top":h, "left":w});
    $(outerdiv).fadeIn("fast");
  });
  $(black).click(function(){
    $(outerdiv).fadeOut("fast");
  });
  $(close).click(function(){
    $(outerdiv).fadeOut("fast");
  });
}