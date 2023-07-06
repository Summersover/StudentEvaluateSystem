import request from '@/utils/request'


export function getStuList() {
    return request({
        url: '/judge/workServe/getStuList',
        method: 'get',
    })
}

export function sendStuNum(username) {
    const data={
        username,
    }
    return request({
        url: '/judge/workServe/sendStuNum',
        method: 'post',
        data: data
    })
}

export function getWorServ() {
    return request({
        url: '/judge/workServe/getWorServ',
        method: 'get',
    })
}

export function getWorServMarkList() {
    return request({
        url: '/judge/workServe/getWorServMarkList',
        method: 'get',
    })
}

export function updateWorServMark(username, mark) {
    const data={
        username,
        mark
    }
    return request({
        url: '/judge/workServe/updateWorServMark',
        method: 'post',
        data: data
    })
}