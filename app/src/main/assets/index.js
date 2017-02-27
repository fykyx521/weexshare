// { "framework": "Vue" }

/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _foo = __webpack_require__(1);

	var _foo2 = _interopRequireDefault(_foo);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	_foo2.default.el = '#root';
	exports.default = new Vue(_foo2.default);

/***/ },
/* 1 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = []

	/* styles */
	__vue_styles__.push(__webpack_require__(2)
	)

	/* script */
	__vue_exports__ = __webpack_require__(3)

	/* template */
	var __vue_template__ = __webpack_require__(4)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "D:\\android\\weex\\weexshare\\share\\src\\foo.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__.style = __vue_options__.style || {}
	__vue_styles__.forEach(function (module) {
	for (var name in module) {
	__vue_options__.style[name] = module[name]
	}
	})

	module.exports = __vue_exports__


/***/ },
/* 2 */
/***/ function(module, exports) {

	module.exports = {
	  "stxt": {
	    "textAlign": "center",
	    "lineHeight": 50,
	    "fontSize": 50
	  },
	  "share": {
	    "width": 750,
	    "height": 100,
	    "borderWidth": 2
	  }
	}

/***/ },
/* 3 */
/***/ function(module, exports) {

	'use strict';

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var share = weex.requireModule('sharemodule');
	var alert = weex.requireModule('model');
	var textShare = { scene: 1, title: '标题', descrption: '描述', 'text': "hellorold" };

	var imageShare = {
	  scene: 0, title: '标题', sharetype: 2,
	  'thumb': "https://f11.baidu.com/it/u=3370260265,1231552087&fm=72",
	  descrption: '描述', 'text': "hellorold", 'img': "https://f11.baidu.com/it/u=3370260265,1231552087&fm=72" };

	var webShare = {
	  scene: 1, title: '标题web', sharetype: 5,
	  'thumb': "https://f11.baidu.com/it/u=3370260265,1231552087&fm=72",
	  descrption: '描述web', 'weburl': "https://www.sxnxl.com/wap" };

	module.exports = {

	  methods: {
	    text: function text() {

	      share.share(1, textShare);
	      alert.toast({
	        message: 'This is a toast',
	        duration: 0.3
	      });
	    },
	    img: function img() {
	      share.share(1, imageShare);
	      // share.share('1',{});
	    },
	    music: function music() {
	      // share.share('1',{});

	    },
	    video: function video() {
	      // share.share('1',{});

	    },
	    webpage: function webpage() {
	      share.share('1', webShare);
	    }

	  }
	};

/***/ },
/* 4 */
/***/ function(module, exports) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('div', [_c('div', {
	    staticClass: ["share"]
	  }, [_c('text', {
	    staticClass: ["stxt"],
	    on: {
	      "click": _vm.text
	    }
	  }, [_vm._v("文本分享")])]), _c('div', {
	    staticClass: ["share"]
	  }, [_c('text', {
	    staticClass: ["stxt"],
	    on: {
	      "click": _vm.img
	    }
	  }, [_vm._v("图片分享")])]), _c('div', {
	    staticClass: ["share"]
	  }, [_c('text', {
	    staticClass: ["stxt"],
	    on: {
	      "click": _vm.music
	    }
	  }, [_vm._v("音乐分享")])]), _c('div', {
	    staticClass: ["share"]
	  }, [_c('text', {
	    staticClass: ["stxt"],
	    on: {
	      "click": _vm.video
	    }
	  }, [_vm._v("视频分享")])]), _c('div', {
	    staticClass: ["share"]
	  }, [_c('text', {
	    staticClass: ["stxt"],
	    on: {
	      "click": _vm.webpage
	    }
	  }, [_vm._v("网页分享")])])])
	},staticRenderFns: []}
	module.exports.render._withStripped = true

/***/ }
/******/ ]);