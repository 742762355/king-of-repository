print("开始执行脚本");
db.policystore.find({"deleteFlag": 0, "sceneType": "3"}).forEach(
    function (scene) {
        var replacedCollectDepartment = replaceWithRule(scene.collectDepartment);
        var replacedPublishDepartment = replaceWithRule(scene.publishDepartment);

        if (replacedCollectDepartment&&replacedPublishDepartment) {
            print("部门不存在! id:" + scene._id);
            return;
        }
        db.policystore.update({"_id": ObjectId(scene._id)}, {
            $set: {
                "collectDepartment": replacedCollectDepartment,
                "publishDepartment": replacedCollectDepartment
            }
        })
    }
)

function replaceWithRule(departmentNum) {
    if (departmentNum) {
        return;
    }
    if (departmentNum.startsWith("HBS")) {
        return departmentNum.replace("HBS", "HBSXN")
    } else {
        var prefix = "XN";
        return departmentNum = prefix + departmentNum;
    }
}