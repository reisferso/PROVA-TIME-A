var UIBootstrapGrowl=function(){return{init:function(){$("#bs_growl_show").click(function(o){$.bootstrapGrowl($("#growl_text").val(),{ele:"body",type:$("#growl_type").val(),offset:{from:$("#growl_offset").val(),amount:parseInt($("#growl_offset_val").val())},align:$("#growl_align").val(),width:parseInt($("#growl_width")),delay:$("#growl_delay").val(),allow_dismiss:$("#glowl_dismiss").is(":checked"),stackup_spacing:10})})}}}();jQuery(document).ready(function(){UIBootstrapGrowl.init()});