/* 对应文件上传的list.jsp */

$(function(){
	var $list =  $("#thelist");
	
	/**
	 * 1、初始化上传控件
	 */
	var uploader = WebUploader.create({
		
		//选完文件后是否自动上传
		auto:false,

	    // swf文件路径
	    swf:'/examination/static/js/webuploader/Uploader.swf',

	    // 文件接收服务端。
	    server: '/examination/',

	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#picker',

	    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	    resize: false
	    
	    /* 只允许接收图片
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    }
	    */
	});
	
	/**
	 * 2、监听文件被添加到控件队列中。(fileQueued:文件添加后被触发的事件)
	 */
	uploader.on('fileQueued', function( file ) {
		console.info("有文件被添加到控件中:文件id:"+file.id+"  文件名称："+file.name);
	    $list.append( '<div id="' + file.id + '" class="item">' +
	        '<h4 class="info">' + file.name + '</h4>' +
	        '<p class="state">等待上传...</p>' +
	    '</div>' );
	});
	
	/**
	 * 3、监听文件上传进度，uploadProgress
	 * 文件上传中，Web Uploader会对外派送uploadProgress事件，其中包含文件对象和该文件当前上传进度
	 */
	uploader.on( 'uploadProgress', function( file, percentage ) {
		
		//获取文件信息div，以及文件信息div后面的进度条，如果进度条不存在就创建一个
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');

	    // 避免重复创建，如果没有就创建一个进度条
	    if ( !$percent.length ) {
	        $percent = $('<div class="progress progress-striped active">' +
	          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	          '</div>' +
	        '</div>').appendTo( $li ).find('.progress-bar');
	    }

	    $li.find('p.state').text('上传中');
	    console.info(percentage);
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	/**
	 * 文件处理成功事件
	 */
	uploader.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).find('p.state').text('已上传');
	});
	
	/**
	 * 文件处理失败事件
	 */
	uploader.on( 'uploadError', function( file ) {
	    $( '#'+file.id ).find('p.state').text('上传出错');
	});
	
	/**
	 * 不管成功或失败都会触发完成事件。
	 */
	uploader.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').fadeOut();
	});
	
});






