function getEventObject(W3CEvent){return W3CEvent||window.event;}function getPointerPosition(e){e=e||getEventObject(e);var x=e.pageX||(e.clientX+(document.documentElement.scrollLeft||document.body.scrollLeft));var y=e.pageY||(e.clientY+(document.documentElement.scrollTop||document.body.scrollTop));return{'x':x,'y':y};}function setOpacity(elem,level){if(elem.filters){elem.style.filter='alpha(opacity='+level*100+')';}else{elem.style.opacity=level;}}function css(elem,prop){for(var i in prop){if(i=='opacity'){setOpacity(elem,prop[i]);}else{}}return elem;}var magnifier={m:null,init:function(magni){var m=this.m=magni||{cont:null,img:null,mag:null,scale:15}css(m.img,{'position':'absolute','width':(m.cont.clientWidth*m.scale)+'px','height':(m.cont.clientHeight*m.scale)+'px'})css(m.mag,{'display':'none','width':m.cont.clientWidth+'px','height':m.cont.clientHeight+'px','position':'absolute','left':m.cont.offsetLeft+m.cont.offsetWidth+10+'px','top':m.cont.offsetTop+'px'})var borderWid=m.cont.getElementsByTagName('div')[0].offsetWidth-m.cont.getElementsByTagName('div')[0].clientWidth;css(m.cont.getElementsByTagName('div')[0],{'display':'none','width':m.cont.clientWidth/m.scale-borderWid+'px','height':m.cont.clientHeight/m.scale-borderWid+'px','opacity':0.5})m.cont.style.cursor='crosshair';m.cont.onmouseover=magnifier.start;},start:function(e){if(document.all){magnifier.createIframe(magnifier.m.img);}this.onmousemove=magnifier.move;this.onmouseout=magnifier.end;},move:function(e){var pos=getPointerPosition(e);this.getElementsByTagName('div')[0].style.display='';css(this.getElementsByTagName('div')[0],{'top':Math.min(Math.max(pos.y-this.offsetTop-parseInt(this.getElementsByTagName('div')[0].style.height)/2,0),this.clientHeight-this.getElementsByTagName('div')[0].offsetHeight)+'px','left':Math.min(Math.max(pos.x-this.offsetLeft-parseInt(this.getElementsByTagName('div')[0].style.width)/2,0),this.clientWidth-this.getElementsByTagName('div')[0].offsetWidth)+'px'})magnifier.m.mag.style.display='';css(magnifier.m.img,{'top':-(parseInt(this.getElementsByTagName('div')[0].style.top)*magnifier.m.scale)+'px','left':-(parseInt(this.getElementsByTagName('div')[0].style.left)*magnifier.m.scale)+'px'})},end:function(e){this.getElementsByTagName('div')[0].style.display='none';magnifier.removeIframe(magnifier.m.img);magnifier.m.mag.style.display='none';},createIframe:function(elem){var layer=document.createElement('iframe');layer.tabIndex='-1';layer.src='javascript:false;';elem.parentNode.appendChild(layer);layer.style.width=elem.offsetWidth+'px';layer.style.height=elem.offsetHeight+'px';},removeIframe:function(elem){var layers=elem.parentNode.getElementsByTagName('iframe');while(layers.length>0){layers[0].parentNode.removeChild(layers[0]);}}}window.onload=function(){magnifier.init({cont:document.getElementById('vertical'),img:document.getElementById('magnifierImg'),mag:document.getElementById('bigView'),scale:3});}