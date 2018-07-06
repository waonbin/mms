(function($) {
    jQuery.fn.LoadImage = function(settings) {
        settings = jQuery.extend({
            scaling: true,
            width: 200,
            height: 200,
            loadpic: ""
        }, settings);
        return this.each(function() {
            $.fn.LoadImage.Showimg($(this), settings);
        });
    };
    $.fn.LoadImage.Showimg = function($this, settings) {
        var src = $this.attr("src");
        var img = new Image();
        img.src = src;
        var autoScaling = function() {
            if (settings.scaling) {
                if (img.width > 0 && img.height > 0) {
                    if (img.width < 100 || img.height < 100)
                        return;
                    var towidth = img.width;
                    var toheight = img.height;
                    if (img.width / img.height >= settings.width / settings.height) {
                        if (img.width > settings.width) {
                            towidth = settings.width;
                            toheight = (img.height * settings.width) / img.width;
                        }
                        else {
                            toheight = img.height * (settings.width / img.width);
                        }
                    }
                    else {
                        if (img.height > settings.height) {
                            toheight = settings.height;
                            towidth = (img.width * settings.height) / img.height;
                        }
                        else {
                            towidth = img.width * (settings.height / img.height);
                        }
                    }
                     
                    $this.attr("style", "display:block;margin:15px auto;heith:" + toheight + "px;width:" + towidth + "px");
                }
            }
        }
        $this.attr("src", "");
        var loading = $("<img alt=\"Loading...\" title=\"Loading....\" src=\"" + settings.loadpic + "\" />");
        $this.hide();
        $this.after(loading);
        $(img).load(function() {
            autoScaling();
            loading.remove();
            $this.attr("src", this.src);            
            $this.show();
        });
    }
})(jQuery);
