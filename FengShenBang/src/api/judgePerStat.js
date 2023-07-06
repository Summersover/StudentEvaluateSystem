import request from '@/utils/request'

export function getStuList() {
    return request({
        url: '/judge/perStat/getStuList',
        method: 'get',
    })
}

export function sendStuNum(username) {
    const data={
        username,
    }
    return request({
        url: '/judge/perStat/sendStuNum',
        method: 'post',
        data: data
    })
}

export function getPerStat1() {
    return request({
        url: '/judge/perStat/getPerStat1',
        method: 'get',
    })
}

export function getPerStat2() {
    return request({
        url: '/judge/perStat/getPerStat2',
        method: 'get',
    })
}

export function getPerStatMarkList() {
    return request({
        url: '/judge/perStat/getPerStatMarkList',
        method: 'get',
    })
}

export function updatePerStatMark(username, mark) {
    const data={
        username,
        mark
    }
    return request({
        url: '/judge/perStat/updatePerStatMark',
        method: 'post',
        data: data
    })
}