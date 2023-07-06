import request from '@/utils/request'



export function getStuList() {
    return request({
        url: '/judge/socPrac/getStuList',
        method: 'get',
    })
}

export function sendStuNum(username) {
    const data={
        username,
    }
    return request({
        url: '/judge/socPrac/sendStuNum',
        method: 'post',
        data: data
    })
}

export function getSocPrac() {
    return request({
        url: '/judge/socPrac/getSocPrac',
        method: 'get',
    })
}

export function getSocPracMarkList() {
    return request({
        url: '/judge/socPrac/getSocPracMarkList',
        method: 'get',
    })
}

export function updateSocPracMark(username, mark) {
    const data={
        username,
        mark
    }
    return request({
        url: '/judge/socPrac/updateSocPracMark',
        method: 'post',
        data: data
    })
}