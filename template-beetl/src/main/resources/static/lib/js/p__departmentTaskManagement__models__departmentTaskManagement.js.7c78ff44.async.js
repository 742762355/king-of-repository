(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[26], {
    vJVS: function (e, t, a) {
        "use strict";
        var n = a("g09b");
        Object.defineProperty(t, "__esModule", {value: !0}), t.default = void 0;
        var s = n(a("d6i3")), i = n(a("p0pE")), u = a("tGYC"), p = a("+p3w"), r = {
            namespace: "departmentTaskManagement",
            state: {list: [], total: 0, pageNum: 0, pageSize: 10},
            effects: {
                fetchList: s.default.mark(function e(t, a) {
                    var n, r, o, d, c, l, f, m, v, g, w, b, y, S, k, z;
                    return s.default.wrap(function (e) {
                        while (1) switch (e.prev = e.next) {
                            case 0:
                                return n = t.payload, r = n.page, o = void 0 === r ? 0 : r, d = n.size, c = void 0 === d ? 10 : d, l = n.query, f = void 0 === l ? {} : l, m = a.put, e.next = 4, (0, p.Code2Name)(u.CORE.queryDepartmentTasMonitorUsingGET({
                                    params: (0, i.default)({
                                        page: o,
                                        size: c
                                    }, f)
                                }), ["RWZL", "taskSubType"]);
                            case 4:
                                return v = e.sent, g = v.content, w = void 0 === g ? [] : g, b = v.totalElements, y = v.size, S = v.number, k = v.dictNames, z = void 0 === k ? {} : k, e.next = 14, m({
                                    type: "saveList",
                                    list: w.map(function (e) {
                                        return (0, i.default)({}, e, {taskSubType_cn: z["RWZL"][e.taskSubType]})
                                    }),
                                    total: b,
                                    pageSize: y,
                                    pageNum: S
                                });
                            case 14:
                            case"end":
                                return e.stop()
                        }
                    }, e)
                })
            },
            reducers: {
                saveList: function (e, t) {
                    var a = t.list, n = t.total, s = t.pageSize, u = t.pageNum;
                    return (0, i.default)({}, e, {list: a, total: n, pageSize: s, pageNum: u})
                }
            }
        }, o = r;
        t.default = o
    }
}]);