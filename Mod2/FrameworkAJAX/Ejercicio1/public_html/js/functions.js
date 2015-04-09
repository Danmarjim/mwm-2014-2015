function getInformation(object) {
    var res = '<ul>';

    for (var property in object) {
        if (typeof object[property] === 'object') {
            res += '<li>' + property + getInformation(object[property]) + '<li>';
        }
        else {
            res += '<li>' + property + ':' + object[property] + '<li>';
        }
    }
    res += '<ul>'
    return res;
}