package com.dou.demo.rtda.heap.methodarea;

import com.dou.demo.classfile.MemberInfo;
import com.dou.demo.rtda.heap.constantpool.AccessFlags;

public class ClassMember {

    public int accessFlags;
    public String name;
    public String descriptor;
    public Class clazz;

    public void copyMemberInfo(MemberInfo memberInfo) {
        this.accessFlags = memberInfo.accessFlags();
        this.name = memberInfo.name();
        this.descriptor = memberInfo.descriptor();
    }

    public boolean isPublic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PUBLIC);
    }

    public boolean isPrivate() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PRIVATE);
    }

    public boolean isProtected() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PROTECTED);
    }

    public boolean isStatic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_STATIC);
    }

    public boolean isFinal() {
        return 0 != (this.accessFlags & AccessFlags.ACC_FINAL);
    }

    public boolean isSynthetic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_SYNTHETIC);
    }

    public String name() {
        return this.name;
    }

    public String descriptor() {
        return this.descriptor;
    }

    public Class clazz() {
        return this.clazz;
    }

    public boolean isAccessibleTo(Class d) {
        if (this.isPublic()) {
            return true;
        }
        Class c = this.clazz;
        if (this.isProtected()) {
            return d == c || c.getPackageName().equals(d.getPackageName());
        }
        if (!this.isPrivate()) {
            return c.getPackageName().equals(d.getPackageName());
        }
        return d == c;
    }

}
