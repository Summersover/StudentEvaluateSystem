import request from "@/utils/request";


export function getTotalMarkList() {
    return request({
        url: '/totalMark/getTotalMarkList',
        method: 'get',
    })
}

