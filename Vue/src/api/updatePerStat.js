import request from '@/utils/request'

// 学生提交个人学年总结
export function updatePerStat(tableData, username, behaviour, study, health) {
    const data={
        tableData,
        username,
        behaviour,
        study,
        health
    }
    return request({
        url: '/student/updatePerStat',
        method: 'post',
        data: data
    })
}

//学生查看已提交信息
export function getPerStat1() {
    return request({
        url: '/student/getPerStat1',
        method: 'get',
    })
}
export function getPerStat2() {
    return request({
        url: '/student/getPerStat2',
        method: 'get',
    })
}

// 学生删除个人学年总结
export function deletePerStat(tableData, username) {
    const data = {
        tableData,
        username,
    }
    return request({
        url: '/student/deletePerStat',
        method: 'post',
        data: data
    })
}

