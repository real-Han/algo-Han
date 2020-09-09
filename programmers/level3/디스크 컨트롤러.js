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
    get isEmpty() {
        return this.size === 0;
    }
    get isFull() {
        return this.size === this.capacity;
    }
    get peek() {
        return !this.isEmpty ? this._heap[1] : null;
    }
    set compare(compare) {
        this._compare = compare;
    }
}

function solution(jobs) {
    const N = jobs.length;
    let total = 0;
    let now = 0;
    const pq = new PriorityQueue();
    pq.compare = (a, b) => a[1] < b[1];
    jobs.sort((a, b) => a[0] < b[0]);
    while (jobs.length > 0 || pq.size > 0) {
        if (pq.size === 0 && jobs.length > 0) {
            now = Math.max(now, jobs[0][0]);
        }
        while (jobs.length > 0 && jobs[0][0] <= now) {
            pq.add(jobs.shift());
        }
        const [req, time] = pq.poll();
        now += time;
        total += now - req;
    }
    return Math.floor(total / N);
}
