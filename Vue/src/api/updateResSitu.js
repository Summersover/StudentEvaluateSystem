import request from '@/utils/request'

// 学生提交科研情况
export function updateResSitu(tableData, username) {
    const data={
        tableData,
        username,
    }
    return request({
        url: '/student/updateResSitu',
        method: 'post',
        data: data
    })
}

//学生查看已提交信息
export function getResSitu() {
    return request({
        url: '/student/getResSitu',
        method: 'get',
    })
}

export function deleteResSitu(tableData, username) {
    const data={
        tableData,
        username,
    }
    return request({
        url: '/student/deleteResSitu',
        method: 'post',
        data: data
    })
}

