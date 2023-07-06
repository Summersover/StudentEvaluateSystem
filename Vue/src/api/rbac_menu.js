import request from '@/utils/request'

export function getMenu() {
    return request({
        url: '/menu/getMenu',
        method: 'get',
    })
}

export function getRole() {
    return request({
        url: '/menu/getRole',
        method: 'get',
    })
}