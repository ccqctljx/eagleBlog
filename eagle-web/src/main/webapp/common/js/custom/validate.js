/**
 * Created by simon on 2017/8/14.
 */
$.isEmptyStr = function(str){
    if(str === null){
        return false;
    }
    if(str === undefined ){
        return false;
    }

    if(str === ''){
        return false;
    }

    if(str == ''){
        return false;
    }

    if(!str){
        return false;
    }

    if(str.length == 0){
        return false;
    }

    return true;
};
