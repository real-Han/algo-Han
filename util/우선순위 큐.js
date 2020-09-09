class PriorityQueue {
    constructor(compare) {
        this._heap = [null];
        if (compare) this.compare = compare;
        this.size = 0;
    }

    _compare(a, b) {
        return a < b;
    }

    _swap(a, b) {
        const tmp = this._heap[a];
        this._heap[a] = this._heap[b];
        this._heap[b] = tmp;
    }

    /**
     * 새로운 원소를 추가한다.
     */
    add(e) {
        if (this.isFull) {
            ++this.size;
            this._heap.push(e);
        } else {
            this._heap[++this.size] = e;
        }

        let node = this.size;
        let parent = Math.floor(node / 2);

        while (
            node > 1 &&
            this._compare(this._heap[node], this._heap[parent])
        ) {
            this._swap(node, parent);
            node = parent;
            parent = Math.floor(node / 2);
        }
    }

    /**
     * 가장 우선순위가 높은 원소를 제거하고, 그 값을 리턴한다.
     * 큐가 비어있다면 null을 리턴한다.
     */
    poll() {
        if (this.isEmpty) return null;

        const ret = this._heap[1];
        this._heap[1] = this._heap[this.size--];
        let node = 1;
        let leftChild, rightChild;
        let leftComp, rightComp;

        while (true) {
            leftChild = node * 2;
            rightChild = leftChild + 1;
            leftComp =
                leftChild <= this.size &&
                this._compare(this._heap[leftChild], this._heap[node]);
            rightComp =
                rightChild <= this.size &&
                this._compare(this._heap[rightChild], this._heap[node]);

            if (leftComp && rightComp) {
                if (
                    this._compare(this._heap[leftChild], this._heap[rightChild])
                ) {
                    rightComp = false;
                } else {
                    leftComp = false;
                }
            }

            if (leftComp) {
                this._swap(node, leftChild);
                node = leftChild;
            } else if (rightComp) {
                this._swap(node, rightChild);
                node = rightChild;
            } else {
                break;
            }
        }

        return ret;
    }

    get capacity() {
        return this._heap.length - 1;
    }

    /**
     * 큐가 비었다면 true, 아니라면 false를 리턴
     */
    get isEmpty() {
        return this.size === 0;
    }

    get isFull() {
        return this.size === this.capacity;
    }

    /**
     * 가장 우선순위가 높은 값을 리턴한다.
     * 큐가 비어있다면 null을 리턴한다.
     */
    get peek() {
        return !this.isEmpty ? this._heap[1] : null;
    }

    /**
     * 우선순위 결정에 사용될 비교 함수 설정.
     */
    set compare(compare) {
        this._compare = compare;
    }
}
