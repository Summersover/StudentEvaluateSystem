import request from '@/utils/request'


export function getStuList() {
    return request({
        url: '/judge/resSitu/getStuList',
        method: 'get',
    })
}


export function sendStuNum(username) {
    const data={
        username,
    }
    return request({
        url: '/judge/resSitu/sendStuNum',
        method: 'post',
        data: data
    })
}

export function getResSitu() {
    return request({
        url: '/judge/resSitu/getResSitu',
        method: 'get',
    })
}

export function getResSituMarkList() {
    return request({
        url: '/judge/resSitu/getResSituMarkList',
        method: 'get',
    })
}

export function updateResSituMark(username, mark) {
    const data={
        username,
        mark
    }
    return request({
        url: '/judge/resSitu/updateResSituMark',
        method: 'post',
        data: data
    })
}